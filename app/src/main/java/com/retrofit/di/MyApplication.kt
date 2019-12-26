package com.retrofit.di

import androidx.multidex.MultiDexApplication

class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        myComponent = DaggerMyComponent.create()
    }

    companion object {
        var myComponent: MyComponent? = null
    }
}
