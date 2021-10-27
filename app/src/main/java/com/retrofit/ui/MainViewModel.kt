package com.retrofit.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.retrofit.data.model.Posts
import com.retrofit.data.remote.RemoteRepository
import com.retrofit.di.MyApplication
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.jetbrains.annotations.NotNull
import javax.inject.Inject

class MainViewModel @Inject constructor(@NotNull appContext: Application) :
    AndroidViewModel(appContext) {

    @Inject
    lateinit var remoteRepository: RemoteRepository

    private lateinit var disposable: Disposable

    var list = MutableLiveData<List<Posts>>()
    var toastMsg = MutableLiveData<String>()
    var showLoader = MutableLiveData<Boolean>()

    init {
        MyApplication.myComponent.inject(this)
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