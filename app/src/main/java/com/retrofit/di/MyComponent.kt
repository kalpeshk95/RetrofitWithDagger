package com.retrofit.di

import com.retrofit.ui.MainViewModel
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component
interface MyComponent {

    fun inject(model: MainViewModel)
}
