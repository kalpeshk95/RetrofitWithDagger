package com.retrofit.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.retrofit.data.model.Posts
import com.retrofit.data.remote.RemoteRepository
import com.retrofit.di.MyApplication
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.annotations.NotNull
import javax.inject.Inject


class MainViewModel(@NotNull appContext: Application) : AndroidViewModel(appContext) {

    @set:Inject
    lateinit var remoteRepository: RemoteRepository

    private lateinit var disposable: Disposable

    var list = MutableLiveData<List<Posts>>()
    var toastMsg = MutableLiveData<String>()
    var showLoader = MutableLiveData<Boolean>()

    init {
        MyApplication.myComponent?.inject(this)
    }

    fun fetchData() {

        showLoader.value = true
        disposable = remoteRepository.fetchData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                list.value = it
                showLoader.value = false
            }, {
                showLoader.value = false
                toastMsg.value = it.message
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}