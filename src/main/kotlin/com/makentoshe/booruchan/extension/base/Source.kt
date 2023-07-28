package com.makentoshe.booruchan.extension.base

import com.makentoshe.booruchan.extension.base.factory.HealthCheckFactory

interface Source {

    /** Should be unique for each source */
    val id: String

    /** Title how it will be displayed to user */
    val title: String

    /** Source base url */
    val host: String

    /** Network request factory for checking source availability */
    val healthCheckFactory: HealthCheckFactory? get() = null
}

