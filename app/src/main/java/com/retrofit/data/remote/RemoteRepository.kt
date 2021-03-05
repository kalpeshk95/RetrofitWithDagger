package com.retrofit.data.remote

import com.retrofit.data.model.Posts
import com.retrofit.di.MyApplication
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RemoteRepository @Inject constructor() : RemoteCallback {

//    private var network: Network = ApiClient.client!!.create(Network::class.java)

    @Inject
    lateinit var network :  Network

    init {
        MyApplication.myComponent.inject(this)
    }

    override fun fetchData(): Observable<List<Posts>> {
        return network.fetch()
    }

//    fun fetchData(callback: RemoteDataManager.RemoteCallback<List<Posts>>) {
//
//        network.fetch().enqueue(object : Callback<List<Posts>> {
//
//            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
//
//                if (response.isSuccessful && response.code() == 200) {
//                    callback.onSuccess(response.body()!!)
//                } else {
//                    callback.onSetMessage("Invalid response returned from server")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
//                callback.onFailure(t)
//            }
//
//        })
//    }
}
