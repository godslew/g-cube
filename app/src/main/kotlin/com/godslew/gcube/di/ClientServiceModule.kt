package com.godslew.gcube.di

import com.godslew.gcube.infra.api.client.BooksClient
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

val clientServiceModule : Module = module {
  single { Retrofit
    .Builder()
    .client(OkHttpClient.Builder().build())
    .baseUrl("https://www.googleapis.com/books/v1/")
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(BooksClient.BooksService::class.java) }
}