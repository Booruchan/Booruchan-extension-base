package com.makentoshe.booruchan.extension.base.factory

import com.makentoshe.booruchan.extension.base.entity.NetworkPost
import com.makentoshe.booruchan.extension.base.network.NetworkRequest
import com.makentoshe.booruchan.extension.base.network.NetworkResponse
import com.makentoshe.booruchan.extension.base.network.text
import com.makentoshe.booruchan.extension.base.parser.FetchPostParser
import com.makentoshe.booruchan.extension.base.settings.SourceSettings

abstract class FetchPostFactory(
    private val fetchPostsParser: FetchPostParser,
    private val sourceSettings: SourceSettings,
) {

    /** Returns a Network request that should be executed by network client */
    abstract fun buildRequest(request: FetchPostRequest): NetworkRequest

    /** Encapsulates parsing network response into a post */
    open fun parseResponse(response: NetworkResponse): NetworkPost {
        return fetchPostsParser.parse(response.content.text)
    }

    data class FetchPostRequest(
        val id: String,
    )
}