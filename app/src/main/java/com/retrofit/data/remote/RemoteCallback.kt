package com.retrofit.data.remote

import com.retrofit.data.model.Posts
import io.reactivex.Observable

interface RemoteCallback {

    fun fetchData() : Observable<List<Posts>>
}