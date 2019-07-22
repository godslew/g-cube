package com.godslew.gcube.di

import com.godslew.gcube.infra.api.client.BooksClient
import org.koin.core.module.Module
import org.koin.dsl.module

val clientModule : Module = module {
  single { BooksClient(get()) }
}