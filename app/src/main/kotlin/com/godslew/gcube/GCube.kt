package com.godslew.gcube

import android.app.Application
import com.godslew.gcube.di.clientModule
import com.godslew.gcube.di.clientServiceModule
import com.godslew.gcube.di.repositoryModule
import com.godslew.gcube.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GCube : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }
    private fun initializeKoin() {
        startKoin {
            androidContext(this@GCube)
            modules(listOf(viewModelModule)
                + listOf(repositoryModule)
                + listOf(clientModule)
                + listOf(clientServiceModule))
        }
    }
}