package com.makentoshe.booruchan.extension.base.factory

import com.makentoshe.booruchan.extension.base.network.NetworkRequest

/** Factory for head request for checking availability */
abstract class HealthCheckFactory {

    /** Returns a Network request that should be executed by network client */
    abstract fun buildRequest(): NetworkRequest
}