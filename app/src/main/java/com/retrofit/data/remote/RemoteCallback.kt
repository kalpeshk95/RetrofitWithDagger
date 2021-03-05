package com.retrofit.data.remote

import com.retrofit.data.model.Posts
import io.reactivex.rxjava3.core.Observable

interface RemoteCallback {

    fun fetchData() : Observable<List<Posts>>
}