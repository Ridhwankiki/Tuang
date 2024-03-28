package com.bdp.tuang.presentation.home_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bdp.tuang.data.remote.FoodCategoriesDataSource
import com.bdp.tuang.data.response_model.FoodCategoriesResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//class FoodCategoriesViewModel {
//}

@HiltViewModel
class FoodCategoriesViewModel @Inject constructor(private val foodCategoriesDataSource: FoodCategoriesDataSource) :
    ViewModel() {

    // setter
    private val _foodCategories = MutableLiveData<FoodCategoriesResponseModel>()
    private val _foodCategoriesError = MutableLiveData<String>()

    // getter
    val foodCategories: LiveData<FoodCategoriesResponseModel> get() = _foodCategories
    val foodCategoriesError: LiveData<String> get() = _foodCategoriesError

    fun getFoodCategories() = viewModelScope.launch(Dispatchers.IO) {
        foodCategoriesDataSource.getFoodCategories().let {
            if (it.isSuccessful) {
                _foodCategories.postValue(it.body())
            } else {
                _foodCategoriesError.postValue(it.message())
            }

        }
    }
}