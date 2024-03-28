package com.bdp.tuang.data.response_model

import com.google.gson.annotations.SerializedName


data class FoodCategoriesResponseModel(
    @SerializedName("categories")
    val categories: List<Category?>?
)