/*
 * Copyright 2021-2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package im.vector.app.features.settings.legals

import im.vector.app.R
import im.vector.app.core.resources.StringProvider
import im.vector.app.features.discovery.ServerPolicy
import im.vector.app.features.settings.VectorSettingsUrls
import javax.inject.Inject

class ElementLegals @Inject constructor(
        private val stringProvider: StringProvider
) {
    /**
     * Use ServerPolicy model.
     */
    fun getData(): List<ServerPolicy> {
        return listOf(
                // Modified for TELEIRAQ on 2026-10-19. Element's service policies do not describe this fork.
                ServerPolicy(stringProvider.getString(R.string.teleiraq_copyright_license), VectorSettingsUrls.COPYRIGHT),
                ServerPolicy(stringProvider.getString(R.string.teleiraq_source_code), VectorSettingsUrls.SOURCE_CODE)
        )
    }
}
