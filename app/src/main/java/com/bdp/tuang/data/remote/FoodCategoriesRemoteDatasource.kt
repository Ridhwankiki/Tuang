package com.bdp.tuang.data.remote

import com.bdp.tuang.data.response_model.FoodCategoriesResponseModel
import retrofit2.Response

interface FoodCategoriesRemoteDatasource {
    suspend fun getFoodCategories() : Response<FoodCategoriesResponseModel>
}