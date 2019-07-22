package com.godslew.gcube.di

import com.godslew.gcube.ui.dashboard.DashboardViewModel
import com.godslew.gcube.ui.home.HomeViewModel
import com.godslew.gcube.ui.notifications.NotificationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val viewModelModule: Module = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DashboardViewModel() }
    viewModel { NotificationsViewModel() }
}