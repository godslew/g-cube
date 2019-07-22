package com.godslew.gcube.infra.api.response

import com.godslew.gcube.domain.entity.Images
import com.godslew.gcube.domain.entity.VolumeInfo
import com.google.gson.annotations.SerializedName
import java.util.*

data class BookResponse(
  @SerializedName("kind") var kind: String,
  @SerializedName("id") var id: String,
  @SerializedName("etag") var etag: String,
  @SerializedName("selfLink") var selfLink: String,
  @SerializedName("volumeInfo") var volumeInfo: VolumeInfoResponse
)

data class VolumeInfoResponse(
  @SerializedName("title") var title: String,
  @SerializedName("subtitle") var subtitle: String,
  @SerializedName("authors") var authors: List<AuthorResponse>?,
  @SerializedName("publisher") var publisher: String,
  @SerializedName("publishedDate") var publishedDate: String,
  @SerializedName("description") var description: String,
  @SerializedName("imageLinks") var imageLinks: ImagesResponse
) {
  fun toVolume(): VolumeInfo {
    return VolumeInfo(
      title = title,
      subtitle = subtitle,
      authors = authors?.map { it.author },
      publisher = publisher,
      publishedDate = Date(),
      description = description,
      images = imageLinks.toImages()
    )
  }
}

data class AuthorResponse(
  @SerializedName("author") var author: String
)

data class ImagesResponse(
  @SerializedName("smallThumbnail") var smallThumbnail: String,
  @SerializedName("thumbnail") var thumbnail: String,
  @SerializedName("small") var small: String,
  @SerializedName("medium") var medium: String,
  @SerializedName("large") var large: String,
  @SerializedName("extraLarge") var extraLarge: String
) {
  fun toImages(): Images {
    return Images(
      smallThumbnail = smallThumbnail,
      thumbnail = thumbnail,
      small = small,
      medium = medium,
      large = large,
      extraLarge = extraLarge
    )
  }
}
