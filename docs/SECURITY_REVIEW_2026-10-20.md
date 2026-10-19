# Committed-file security review — 2026-10-20

Scope: local HEAD `8a333f3`, tracked-text credential-pattern scan, signing and
workflow configuration, changes since initial commit `45e6ee1`, and selected
network/authentication paths. This is a targeted review, not a full security
audit, dependency vulnerability scan, or confirmation that no other secrets exist.
Remote repository visibility, GitHub secrets, running Actions jobs and Play Console
state were not inspected. No secret values are reproduced here.

## High priority: release signing material in Git

- `teleiraq.keystore` is tracked.
- `gradle.properties:31–34` contains the release keystore path and signing credentials.
- `vector-app/keystore.properties:8–11` also contains signing configuration and passwords.
- `vector-app/build.gradle:237–241` consumes the release signing properties.
- These files are present in initial commit `45e6ee1`; removing them in a later
  commit does not remove them from history or other clones.

Anyone with access to this repository may have obtained this material. Treat it
as exposed if the repository has been shared. The user confirmed Google Play App
Signing is used, but this does not establish which key the committed keystore holds.
Compare its certificate fingerprint with the upload and app-signing certificates
in Play Console. If it is the upload key, create a replacement outside the repo,
export only its public certificate and request an upload-key reset. If it also
matches the app-signing certificate, review Play's compromised app-signing-key
upgrade procedure; an upload-key reset alone is insufficient.

Then remove production keystores and passwords from tracking, ignore local signing
files, and load credentials from an untracked local file/environment or secure
CI storage. Preserve the local key backup until the replacement is confirmed.
Coordinate history cleanup with collaborators after key replacement. History
rewriting cannot revoke copies already downloaded. Changing only the keystore
password does not revoke an exposed private key.

Follow-up cleanup: production/nightly keystores and `vector-app/keystore.properties`
were removed from Git tracking while preserving local copies. Signing properties
were moved out of tracked `gradle.properties` into ignored `signing.local.properties`.
The Gradle app module now reads that optional local file, with Gradle project
properties taking precedence. The conventional shared Android debug key remains
tracked for development only. Fresh clones need private signing configuration
before producing signed releases; no production credentials are provided in Git.

Remote `main` was confirmed to point to the reviewed commit. Two remote Dependabot
branches also exist. The cleanup commit does not remove the previous copies from
their history. No keys have been rotated, no history rewritten, and no Play
Console settings changed.

Reference: https://support.google.com/googleplay/android-developer/answer/9842756

## Medium priority: authentication certificate errors can be bypassed

`FtueAuthWebFragment.kt:123` and `LoginWebFragment.kt:126` offer a trust button
that calls `SslErrorHandler.proceed()` after an SSL certificate error. CAPTCHA
WebViews have related behavior (`CaptchaWebview.kt:132`, `LoginCaptchaFragment.kt:108`).
An attacker with a network interception opportunity can present an invalid
certificate and obtain authentication traffic if the user accepts it. This is
not an automatic unconditional TLS bypass, and is inherited behavior rather
than evidence of malicious code. Prefer cancelling invalid-certificate requests
for the production TELEIRAQ authentication flow; fix the server certificate
instead of asking users to bypass errors. Changes to these flows need device tests.

## GitHub workflow removal

Removed all 14 tracked `.github/workflows/*.yml` files from the working tree as
requested. This removes builds, tests, nightly releases, docs publishing, triage,
sync and wrapper-validation/update jobs from the next committed version. The
deletions must be committed and pushed to affect GitHub. Existing/queued jobs and
workflows on other branches are unaffected; cancel/disable them separately in
GitHub if required. Dependabot configuration and issue templates remain.

The inherited workflows referenced upstream service secrets and third-party
actions using mutable tags. A `pull_request_target` triage workflow was restricted
to the upstream repository. These observations alone do not prove secret leakage.

## Other observations and limits

- No additional private-key PEM blocks, GitHub PATs, AWS access-key IDs or Slack
  tokens matched the targeted current tracked-text scan. This does not cover all
  secret formats, binary contents or every historical blob.
- Firebase client API keys occur in tracked `google-services.json` files. These
  are not equivalent to service-account private keys. Cloud API restrictions,
  Firebase authorization rules and project ownership still need separate review.
- The shared debug keystore is expected for development; never use it for a
  production release. The inherited nightly keystore also needs an ownership/use
  review before enabling nightly signing.
- App backups are disabled. Network configuration rejects cleartext by default
  but allows specified local/onion domains. No blanket trust-all replacement was
  established by the inspected paths.
- The crypto adapter uses `TrustRequirement.UNTRUSTED` both in an existing decrypt
  path and the updated sync API call. This is not evidence that encryption is
  disabled; no change to encryption policy was made during this review.
- Gradle wrapper downloads have a configured SHA-256 checksum. Dependency artifact
  verification metadata was not found; this review did not validate all dependencies
  or native binaries against advisories.
- The recent legal-page commits contain notices/resources/navigation changes;
  no executable download or secret was identified in those changes.

Validation: confirmed all workflow YAML files are absent from the working tree;
reviewed deletion diff and whitespace. No application code was changed in this
turn, so an Android build was not required for the workflow removals.
