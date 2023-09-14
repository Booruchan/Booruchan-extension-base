package com.makentoshe.booruchan.extension.base.parser

import com.makentoshe.booruchan.extension.base.entity.NetworkAutocomplete
import com.makentoshe.booruchan.extension.base.network.NetworkResponse

/**
 * Represents how [NetworkResponse] from [AutocompleteSearchParser] will be parsed.
 *
 * There are several schemes that can be returned. The default one is Json,
 * but some services may return Xml, so we want to be ready to implement
 * own parser for each source factory.
 * */
interface AutocompleteSearchParser {

    /** Parse input string from the network response into list of posts that were requested */
    fun parse(string: String): List<NetworkAutocomplete>
}