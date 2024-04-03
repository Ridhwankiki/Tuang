package com.bdp.tuang.presentation.favorite_meals_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bdp.tuang.data.remote.JapaneseRemoteDatasource
import com.bdp.tuang.data.response_model.JapaneseResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JapaneseViewModel @Inject constructor(
    private val japaneseRemoteDatasource: JapaneseRemoteDatasource
): ViewModel() {

    // setter
    private val _japanese= MutableLiveData<JapaneseResponseModel>()
    private val _japaneseError = MutableLiveData<String>()
    // getter
    val japanese: LiveData<JapaneseResponseModel>
        get() = _japanese


    val japaneseError: LiveData<String>
        get() = _japaneseError


    fun getJapanese() = viewModelScope.launch(Dispatchers.IO){
        japaneseRemoteDatasource.getJapanese().let {
            if (it.isSuccessful){
                _japanese.postValue(it.body())
            } else{
                _japaneseError.postValue(it.message())
            }
        }
    }

}