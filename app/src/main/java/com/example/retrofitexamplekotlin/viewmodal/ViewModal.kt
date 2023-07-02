package com.example.retrofitexamplekotlin.viewmodal

import android.util.Log
import androidx.lifecycle.*
import com.example.retrofitexamplekotlin.Modal.ModelList
import com.example.retrofitexamplekotlin.data.RepoInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModal  @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repo: RepoInterface
) : ViewModel() {
    private val _mainResponse:
            MutableLiveData<ModelList> = MutableLiveData()
    val mainResponse:
            LiveData<ModelList>
        get() = _mainResponse

    fun getData() {
        viewModelScope.launch {
            try {

                _mainResponse.postValue(repo.getModel())
            } catch (e: Exception) {
                Log.e("here", e.message.toString())
            }
        }
    }
}