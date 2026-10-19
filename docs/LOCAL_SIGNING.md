# Local release signing

Do not commit keystores or signing passwords. This checkout retains existing
signing files locally; the previously committed key must still be replaced using
the appropriate Google Play procedure after determining its role.

The app reads `signing.local.properties` from the repository root. For a fresh
checkout, create that ignored file with these property names and your private
values:

```properties
signing.element.storePath=/absolute/path/to/private-upload.keystore
signing.element.storePassword=YOUR_LOCAL_VALUE
signing.element.keyId=YOUR_LOCAL_ALIAS
signing.element.keyPassword=YOUR_LOCAL_VALUE
```

Use forward slashes for Windows paths. Relative store paths resolve from the
`vector-app` directory, matching the original build configuration. Gradle project
properties (for example user-level Gradle configuration) override this local file.
Avoid putting passwords in shell command arguments or logs.

Nightly builds additionally use `signing.element.nightly.keyId`,
`signing.element.nightly.keyPassword`, and `signing.element.nightly.storePassword`;
their keystore stays at the ignored `vector-app/signature/nightly.keystore` path.
Existing `ELEMENT_ANDROID_NIGHTLY_*` environment overrides remain supported.

The shared debug keystore is intentionally public and must never be used for
production. A cleanup commit does not revoke keys or erase historical copies.
