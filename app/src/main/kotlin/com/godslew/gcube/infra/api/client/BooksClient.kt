package com.godslew.gcube.infra.api.client

import com.godslew.gcube.infra.api.response.BookListResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

class BooksClient(
    private val service: BooksService
) {
    fun fetchBooks(query: String): Single<BookListResponse> {
        return service.books(query).singleOrError()
    }
    interface BooksService {
        @GET("volumes")
        fun books(
            @Query("q") query: String
        ): Observable<BookListResponse>
    }
}