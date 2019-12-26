package com.retrofit.data.remote

import com.retrofit.data.model.Posts
import io.reactivex.Observable
import retrofit2.http.GET

interface Network {

    @GET("5bbc2fc0320000620027eada?-mockydelay=2s")
    fun fetch(): Observable<List<Posts>>

}
