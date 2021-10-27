package com.retrofit.di

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        myComponent = DaggerMyComponent.builder().appModule(AppModule()).build()
    }

    companion object {
        lateinit var myComponent: MyComponent
    }
}
