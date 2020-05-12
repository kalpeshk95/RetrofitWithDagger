package com.retrofit.di

import com.retrofit.data.remote.RemoteRepository
import com.retrofit.ui.MainViewModel
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface MyComponent {

    fun inject(model: MainViewModel)

    //New code for retrofit injection
    fun inject(repository: RemoteRepository)
}
