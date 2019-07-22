package com.godslew.gcube.infra.api.response

import com.google.gson.annotations.SerializedName

data class BookListResponse (
    @SerializedName("items") var items: List<BookResponse>?,
    @SerializedName("kind") var kind: String,
    @SerializedName("totalItems") var totalItems: Int
)

