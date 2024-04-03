package com.bdp.tuang.data.remote

import com.bdp.tuang.data.response_model.FavoriteMealsResponseModel
import retrofit2.Response

interface FavoriteMealsRemoteDatasource {
    suspend fun getFavoriteMeals() : Response<FavoriteMealsResponseModel>
}