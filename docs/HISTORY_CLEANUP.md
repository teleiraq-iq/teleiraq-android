# Signing history cleanup — 2026-10-20

Repository: `teleiraq-iq/teleiraq-android` (the previous owner URL redirects here).

Rewritten and pushed with explicit force-with-lease expectations:

- `main`: `76583ab018e4d07d86f468d0de9d27ecc9f26663` before the follow-up documentation commit.
- `dependabot/gradle/io.element.android-wysiwyg-2.42.1`: `0c19514177e5970f15a9a647c9520adb620f05cc`.
- `dependabot/gradle/org.matrix.rustcomponents-crypto-android-26.05.12`: `c3557f3f88766f9c0d043569d4a0ae26f887af25`.

All historical versions of `teleiraq.keystore`, `vector-app/keystore.properties`,
`vector-app/signature/nightly.keystore`, and `signing.local.properties` were removed
from rewritten history. Historical signing-property assignment lines were removed.
Current documentation examples contain placeholders only. The public development
debug keystore remains intentionally tracked.

Verification scanned all 9 rewritten commits and 6,494 reachable blobs before
push, including the rewritten local PR refs, for removed paths and the actual
release password values. The three GitHub branch heads were checked after pushing.
GitHub PR refs are managed by GitHub and cannot be rewritten directly by Git push.

## Remaining GitHub cleanup (request not submitted)

Information to provide to GitHub Support for sensitive-data cleanup:

- Repository: `teleiraq-iq/teleiraq-android`.
- Affected pull requests: 2, PR #1 and PR #2.
- First changed commit: `45e6ee1ae02e2d85012ab2a7ac2472e8b3a3d413`.
- Removed data: private signing keystores and signing passwords, not just public certificates.
- All writable remote branches were rewritten. No remote tags were listed.
- Immediately after the push, `refs/pull/1/merge` still referenced old history.
  Request review of both PRs, cached commit views and server object retention.
- The history tool did not report orphaned LFS objects.

GitHub Support decides eligibility for purging retained sensitive data, particularly
where rotating the credential mitigates the risk. No full server-side erasure is
claimed by this cleanup.

Reference: https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/removing-sensitive-data-from-a-repository

## Local copies and key replacement

Collaborators should freshly clone the repository and preserve/reapply only reviewed
uncommitted work. Do not merge or push old history back into the cleaned branches.
Other clones/forks, local reflogs and app-managed local backup refs may retain old
objects; this operation does not claim to wipe them. Do not use a mirror push from
an old clone. This checkout's active main and remote branch refs are aligned with
the rewritten history, while ignored private signing files were preserved exactly.

Replace the exposed key using the appropriate Google Play upload-key reset or
app-signing-key upgrade process after identifying its certificate. History cleanup
does not revoke keys or remove copies already obtained by others.
