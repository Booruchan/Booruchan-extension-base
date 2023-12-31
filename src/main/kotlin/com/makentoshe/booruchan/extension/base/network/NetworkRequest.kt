package com.makentoshe.booruchan.extension.base.network

/**
 * @param url on which address request will be sent
 * @param method will be mapped to the network library method analog
 * @param parameters query parameters
 * */
data class NetworkRequest(
    val url: String,
    val method: NetworkMethod = NetworkMethod.Get,
    val parameters: Map<String, String> = emptyMap(),
)