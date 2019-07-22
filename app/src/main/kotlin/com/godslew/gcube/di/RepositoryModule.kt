package com.godslew.gcube.di

import com.godslew.gcube.infra.repository.BookRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule : Module = module{
  single { BookRepository(get()) }
}