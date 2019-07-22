package com.godslew.gcube.domain.entity

import java.util.*

data class Book(
    val id: String,
    val kind: String,
    val eTag: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo?
)

data class VolumeInfo(
  val title: String,
  val subtitle: String,
  val authors: List<String>?,
  val publisher: String,
  val publishedDate: Date,
  val description: String,
  val images: Images
)

data class Images(
    val smallThumbnail: String,
    val thumbnail: String,
    val small: String,
    val medium: String,
    val large: String,
    val extraLarge: String
)