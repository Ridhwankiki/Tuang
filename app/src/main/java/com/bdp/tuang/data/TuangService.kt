package com.bdp.tuang.data

import com.bdp.tuang.data.response_model.FavoriteMealsResponseModel
import com.bdp.tuang.data.response_model.FoodCategoriesResponseModel
import com.bdp.tuang.data.response_model.JapaneseResponseModel
import com.bdp.tuang.data.response_model.RecommendedResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface TuangService {
    @GET("/api/json/v1/1/categories.php")
    suspend fun getFoodCategories() : Response<FoodCategoriesResponseModel>

    @GET("/api/json/v1/1/filter.php?a=Canadian")
    suspend fun getFavoriteMeals() : Response<FavoriteMealsResponseModel>

    @GET("/api/json/v1/1/filter.php?a=Japanese")
    suspend fun getJapanese() : Response<JapaneseResponseModel>

    @GET("/api/json/v1/1/search.php?f=a")
    suspend fun getRecommended() : Response<RecommendedResponseModel>
}