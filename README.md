# TELEIRAQ for Android

TELEIRAQ is a messaging app for Android built on the Matrix protocol. It lets you stay in touch through direct messages, group conversations, and voice and video calls, with support for end-to-end encryption in encrypted rooms.

The app connects to the TELEIRAQ homeserver at `https://im.teleiraq.com` and is based on Element Classic Android.

## Features

- Direct messages and group chat rooms.
- End-to-end encrypted conversations in rooms where encryption is enabled, with device verification and encryption key backup support.
- Voice and video calling, subject to server support and configuration.
- Sharing photos, videos, files, and voice messages.
- Message replies, reactions, and threaded conversations.
- Location sharing, including live location.
- Notifications to keep up with new messages.

## TELEIRAQ configuration

This fork uses TELEIRAQ branding and the Android application ID `iq.teleiraq.app.android`. It is configured to use the TELEIRAQ homeserver and push notification gateway.

Analytics and the built-in bug reporting feature are disabled in the current configuration. Location sharing and support for external UnifiedPush distributors are enabled. Notification delivery depends on the build variant and the device's notification settings.

## Development

This repository contains the Android app and its Matrix Android SDK modules. The app is primarily written in Kotlin and uses Gradle for builds.

See the [contribution and build guide](./CONTRIBUTING.md) for development setup and the [developer onboarding guide](./docs/_developer_onboarding.md) for the project architecture. These guides were inherited from upstream and may still contain Element-specific references.

The main app module is `vector-app`. TELEIRAQ's app identity is configured in [vector-app/build.gradle](./vector-app/build.gradle), and server settings and feature flags are maintained in [vector-config](./vector-config).

## Upstream attribution and license

TELEIRAQ is a modified version of [Element Android](https://github.com/element-hq/element-android), developed by New Vector Ltd (Element). This repository retains the upstream copyright and license notices. TELEIRAQ is an independent fork and is not an official Element release.

Copyright (c) 2018 - 2025 New Vector Ltd

This fork is distributed under the GNU Affero General Public License, version 3 or (at your option) any later version (`AGPL-3.0-or-later`). See [LICENSE](./LICENSE) for the full license text. Existing file-level copyright and license notices also apply to their respective files.

This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program. If not, see <https://www.gnu.org/licenses/>.

The upstream Element project also offers its code under a separate [Element Commercial License](./LICENSE-COMMERCIAL). That option does not automatically cover modifications made in this fork.

Fork source: [TELEIRAQ Android](https://github.com/moahmmadjaber/teleiraq-android).
See the dated [modification notice](./FORK_CHANGES.md) and
[release compliance review](./docs/FORK_COMPLIANCE.md), including source publication,
remaining branding work and the upstream README/file-header licensing discrepancy.
