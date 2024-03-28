package com.bdp.tuang.data.remote

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.response_model.FoodCategoriesResponseModel
import retrofit2.Response
import javax.inject.Inject

class FoodCategoriesDataSourceImpl @Inject constructor(val service: TuangService) : FoodCategoriesDataSource {
    override suspend fun getFoodCategories(): Response<FoodCategoriesResponseModel> {
        return service.getFoodCategories()
    }


}