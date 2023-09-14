package com.makentoshe.booruchan.extension.base.entity

/** Entity represents a single network tag for autocompletion */
interface NetworkAutocomplete {
    val title: String
    val value: String
    val count: Int
}