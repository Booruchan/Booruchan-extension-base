package com.makentoshe.booruchan.extension.base.factory

import com.makentoshe.booruchan.extension.base.entity.NetworkAutocomplete
import com.makentoshe.booruchan.extension.base.network.NetworkRequest
import com.makentoshe.booruchan.extension.base.network.NetworkResponse
import com.makentoshe.booruchan.extension.base.network.text
import com.makentoshe.booruchan.extension.base.parser.AutocompleteSearchParser
import com.makentoshe.booruchan.extension.base.settings.AutocompleteSearchSettings
import com.makentoshe.booruchan.extension.base.settings.SourceSettings

/** Factory for fetching possible completions of the typed tag. */
abstract class AutocompleteSearchFactory(
    private val autocompleteSearchParser: AutocompleteSearchParser,
    private val sourceSettings: SourceSettings,
) {
    /** All autocompletion settings stores here */
    open val settings: AutocompleteSearchSettings = AutocompleteSearchSettings(sourceSettings)

    /** Returns a Network request that should be executed by network client */
    abstract fun buildRequest(request: AutocompleteSearchRequest): NetworkRequest

    /** Encapsulates parsing network response into list of posts */
    open fun parseResponse(response: NetworkResponse): List<NetworkAutocomplete> {
        return autocompleteSearchParser.parse(response.content.text)
    }

    /** @param autocomplete query that should be autocompleted */
    data class AutocompleteSearchRequest(
        val autocomplete: String,
    )
}
