package com.makentoshe.booruchan.extension.base.entity

/** Entity represents a single network post (image with some metadata, etc) */
interface NetworkPost {
    val id: Int
    val previewImageUrl: String
    val previewImageWidth: Int
    val previewImageHeight: Int
}