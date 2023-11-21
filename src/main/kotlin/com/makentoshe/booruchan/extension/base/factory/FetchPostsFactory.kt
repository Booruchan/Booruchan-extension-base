package com.makentoshe.booruchan.extension.base.factory

import com.makentoshe.booruchan.extension.base.entity.NetworkPost
import com.makentoshe.booruchan.extension.base.network.NetworkRequest
import com.makentoshe.booruchan.extension.base.network.NetworkResponse
import com.makentoshe.booruchan.extension.base.network.text
import com.makentoshe.booruchan.extension.base.parser.FetchPostsParser
import com.makentoshe.booruchan.extension.base.settings.FetchPostsSettings
import com.makentoshe.booruchan.extension.base.settings.SourceSettings

/** Factory for fetching posts. Each post represents image and some metadata for it */
abstract class FetchPostsFactory(
    private val fetchPostsParser: FetchPostsParser,
    private val sourceSettings: SourceSettings,
) {
    /** All search settings stores here */
    open val settings: FetchPostsSettings = FetchPostsSettings(sourceSettings)

    /** Initial page number for api. Mostly it is 0 but in some cases pagination might be started from other page */
    @Deprecated(message = "Deprecated. Use settings to access this field")
    open val initialPageNumber: Int = settings.initialPageNumber

    /** How many posts will be requested per page. Default value is 30 */
    @Deprecated(message = "Deprecated. Use settings to access this field")
    open val requestedPostsPerPageCount: Int = settings.requestedPostsPerPageCount

    /** How search tags should be separated */
    @Deprecated(message = "Deprecated. Use settings to access this field")
    open val searchTagSeparator: String = settings.searchSettings.searchTagAnd

    /** Returns a Network request that should be executed by network client */
    abstract fun buildRequest(request: FetchPostsRequest): NetworkRequest

    /** Encapsulates parsing network response into list of posts */
    open fun parseResponse(response: NetworkResponse): List<NetworkPost> {
        return fetchPostsParser.parse(response.content.text)
    }

    /**
     *  @param count how many posts we want to retrieve. There might be a hard limit on backend side
     *  for posts per request. The [requestedPostsPerPageCount] value can be used as a default value.
     *  @param page the page number for pagination. Pagination starts from the [initialPageNumber]
     *  @param tags the tags to search for. All tags should be separated by [searchTagSeparator] and
     *  joined into the string.
     *  */
    data class FetchPostsRequest(
        val count: Int,
        val page: Int,
        val tags: String,
    )
}
