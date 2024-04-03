package com.bdp.tuang.data.remote

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.response_model.FavoriteMealsResponseModel
import retrofit2.Response
import javax.inject.Inject

class FavoriteMealsRemoteDatasourceImpl  @Inject constructor(
    val service: TuangService
) :
    FavoriteMealsRemoteDatasource {
    override suspend fun getFavoriteMeals(): Response<FavoriteMealsResponseModel> {
        return service.getFavoriteMeals()
    }


}