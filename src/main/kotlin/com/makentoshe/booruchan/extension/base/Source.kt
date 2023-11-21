package com.makentoshe.booruchan.extension.base

import com.makentoshe.booruchan.extension.base.factory.AutocompleteSearchFactory
import com.makentoshe.booruchan.extension.base.factory.FetchPostsFactory
import com.makentoshe.booruchan.extension.base.factory.HealthCheckFactory
import com.makentoshe.booruchan.extension.base.settings.SourceSettings

interface Source {

    /** Should be unique for each source */
    val id: String

    /** Title how it will be displayed to user */
    val title: String

    /** Source base url */
    val host: String

    val settings: SourceSettings

    /** Network request factory for checking source availability */
    val healthCheckFactory: HealthCheckFactory? get() = null

    /** Network request and parsing providing factory for retrieving posts */
    val fetchPostsFactory: FetchPostsFactory? get() = null

    /** Network request and parsing providing factory for autocompleting search */
    val autocompleteSearchFactory: AutocompleteSearchFactory? get() = null
}
