package com.godslew.gcube.ui.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.godslew.gcube.infra.repository.BookRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
  private val repository: BookRepository
) : ViewModel(
) {
  private val disposables = CompositeDisposable()
  private val _text = MutableLiveData<String>().apply {
    value = "This is home Fragment"
  }
  val text: LiveData<String> = _text

  fun fetchBooks() {
    repository.fetchBooks(query = "intitle:変態王子と笑わない猫")
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .doOnSuccess {
        Log.d(TAG, "response=$it")
      }
      .doOnError {
        Log.d(TAG, "response=$it")
      }
      .subscribe()
      .addTo(disposables)
  }

  fun onDestroy() {
    disposables.dispose()
  }
}