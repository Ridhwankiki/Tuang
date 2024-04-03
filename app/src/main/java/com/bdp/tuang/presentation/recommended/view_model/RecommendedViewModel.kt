package com.bdp.tuang.presentation.recommended.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bdp.tuang.data.remote.RecommendedRemoteDatasource
import com.bdp.tuang.data.response_model.RecommendedResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendedViewModel @Inject constructor(
    private val recommendedRemoteDatasource: RecommendedRemoteDatasource
): ViewModel() {

    // setter
    private val _recommended= MutableLiveData<RecommendedResponseModel>()
    private val _recommendedError = MutableLiveData<String>()
    // getter
    val recommended: LiveData<RecommendedResponseModel>
        get() = _recommended


    val recommendedError: LiveData<String>
        get() = _recommendedError


    fun getRecommended() = viewModelScope.launch(Dispatchers.IO){
        recommendedRemoteDatasource.getRecommended().let {
            if (it.isSuccessful){
                _recommended.postValue(it.body())
            } else{
                _recommendedError.postValue(it.message())
            }
        }
    }

}