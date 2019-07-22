package com.godslew.gcube.infra.repository

import com.godslew.gcube.domain.entity.Book
import com.godslew.gcube.infra.api.client.BooksClient
import io.reactivex.Single

class BookRepository(
  private val client: BooksClient
) {
  fun fetchBooks(query: String): Single<List<Book>> {
    print(query)
    return client.fetchBooks(query)
      .map {
        it.items?.map { res ->
          Book(
            id = res.id,
            kind = res.kind,
            eTag = res.etag,
            selfLink = res.selfLink,
            volumeInfo = res.volumeInfo.toVolume()
          )
        }
      }
  }
}