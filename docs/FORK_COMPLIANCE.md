# TELEIRAQ release compliance review

Review date: 2026-10-19. These changes prepare the fork for distribution;
they do not establish that any existing APK or future release is compliant.

## License and attribution

Keep `LICENSE` verbatim, `AUTHORS.md`, all applicable copyright and attribution
notices, third-party license texts, and upstream history. Keep dated modification
notices in `FORK_CHANGES.md` and release notes as the fork evolves. Do not replace
upstream copyright with the operator's name. Add a real contributor's copyright
only where ownership and authorship are established.

Upstream's README expressly offers AGPL version 3 or later. Many source files
instead say `AGPL-3.0-only OR LicenseRef-Element-Commercial`. This patch preserves
those notices rather than rewriting upstream's grants. Both include AGPL v3;
obtain upstream clarification before relying on a later version for files whose
headers restrict that choice. The README-level election is not a relicensing of
separately licensed dependencies. `LICENSE-COMMERCIAL` does not grant a commercial
license to the fork or its modifications.

The Settings root now includes a dedicated Legal page. It exposes the fork source and an offline copyright,
redistribution, warranty and license notice. Existing third-party notice paths
are retained. Check dependency notices against the actual release dependency
graph, including bundled Rust/native libraries and each GPlay/F-Droid flavor;
the inherited HTML list alone is not evidence of complete dependency coverage.

## Required release work

1. Confirm that `https://github.com/moahmmadjaber/teleiraq-android` (taken from the
   local origin remote) is accessible to recipients without credentials. Public
   access could not be verified during this review. If another location is used,
   update `VectorSettingsUrls.SOURCE_CODE`, the bundled legal page and README.
2. For each APK/AAB, publish the exact corresponding source, including fork edits,
   build/configuration scripts and needed dependency sources, at an immutable
   release tag or source archive. Include a mapping from binary version/hash to
   source commit/archive, build variant, toolchain versions and build instructions.
   A link to upstream or a moving branch alone does not establish correspondence.
3. Put a clear no-charge source download link alongside each binary download and
   in store/release descriptions. Follow AGPL section 6's applicable distribution
   method; retain availability for its required period. If section 6 Installation
   Information applies to a User Product, supply it. Never publish service secrets
   or production signing credentials as routine source packaging.
4. Preserve the prominent source offer for remote users where section 13 applies.
   This client review does not audit the separate homeserver or other services.
5. Build both intended distribution flavors. On a device, open Settings > Legal,
   check offline copyright/license display, online source access and third-party
   notices. Confirm the shipped source actually builds the released variant.
6. Update `FORK_CHANGES.md` for each release; keep downstream changes under the
   applicable AGPL terms and avoid additional restrictions on recipients' rights.

## Branding and operator decisions

Already configured: TELEIRAQ app name, independent Android application ID,
homeserver/push endpoints, fork attribution and disclaimer of Element affiliation.
The English store title and descriptions are corrected by this patch.

Before publishing, review all localized `fastlane/metadata/android` descriptions,
screenshots, store graphics, launcher PNGs (all densities and monochrome),
`vector-app/src/main/ic_launcher-playstore.png`, onboarding and analytics screens.
Some drawables retain historical Element filenames but already contain replacement
artwork: filenames and internal `im.vector` packages alone are not product branding.
Inspect rendered artwork before deciding whether it needs replacement. In
particular inspect `element_logo_stars.xml`, `element_logotype.xml`, and the unused
or alternate `drawable-anydpi-v26/ic_launcher_foreground.xml`. Preserve factual
references to third-party services and upstream copyright; do not globally replace
every occurrence of Element, Matrix, Riot, or New Vector.

Provide the operator's legal identity, TELEIRAQ support URL, privacy policy and
acceptable-use terms. `VectorSettingsUrls.HELP` and other consumers of the upstream
policy constants still need review; removing entries from the app Legal section
does not replace operator policies elsewhere. Do not invent URLs or copy Element's
service terms as TELEIRAQ's terms. Confirm rights to all replacement artwork.

Element's trademark policy requires a distinct identity and permits factual plain
text attribution under its conditions. AGPL code permission is not trademark
permission. Retain the independent-fork statement and do not imply endorsement.

## References

Validation of this patch: Settings navigation target and resource XML checked;
bundled AGPL text checked against `LICENSE`; upstream `LICENSE`,
`LICENSE-COMMERCIAL` and `AUTHORS.md` left unchanged. Debug compilation reached
resource generation but failed in the existing dialpad module with
`invalid source release: 21` under the configured Java 17 environment. A successful
Java 21 build and on-device review remain required.

- Upstream license election: https://github.com/element-hq/element-android#copyright-and-license
- AGPL sections 1, 4–6, 7 and 13: ../LICENSE
- Trademark policy: https://element.io/en/legal/trademark-policy
