package com.bdp.tuang.data

import com.bdp.tuang.data.response_model.FoodCategoriesResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface TuangService {

    @GET("/api/json/v1/1/categories.php")
    suspend fun getFoodCategories(): Response<FoodCategoriesResponseModel>
}