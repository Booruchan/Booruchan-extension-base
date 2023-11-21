package com.makentoshe.booruchan.extension.base.settings

data class FetchPostsSettings internal constructor(
    /** Initial page number for api. Mostly it is 0 but in some cases pagination might be started from other page */
    val initialPageNumber: Int = 0,
    /** How many posts will be requested per page. Default value is 30 */
    val requestedPostsPerPageCount: Int = 30,
    /** Contains settings, several predefined tags and their possible values for enhance ui */
    val searchSettings: FetchPostsSearchSettings = FetchPostsSearchSettings(),
) {
    constructor(sourceSettings: SourceSettings) : this(
        initialPageNumber = sourceSettings.searchSettings.initialPageNumber,
        requestedPostsPerPageCount = sourceSettings.searchSettings.requestedPostsPerPageCount,
        searchSettings = FetchPostsSearchSettings(
            searchTagSeparator = sourceSettings.searchSettings.searchTagSeparator,
            searchTagNegator = sourceSettings.searchSettings.searchTagNegator,
        )
    )
}

data class FetchPostsSearchSettings(
    /** How search tags should be separated */
    val searchTagSeparator: String = " ",
    /** How search tags should be negated, to exclude it from the search */
    val searchTagNegator: String = "-",
    /** Possible values for rating tag to help build convenient ui */
//    val predefinedRatingTagSetting: FetchPostsSearchTagSetting? = null,
)

data class FetchPostsSearchTagSetting(
    /** Tag title used in search query */
    val tag: String,
    /** Tag value used in search query */
    val value: FetchPostsSearchTagValue,
)

sealed interface FetchPostsSearchTagValue {

    /** Multiple choices between values */
    data class MultipleValues(
        val values: List<String>,
    ) : FetchPostsSearchTagValue

    /** Single choice between values */
    data class SingleValue(
        val values: List<String>,
    ) : FetchPostsSearchTagValue
}
