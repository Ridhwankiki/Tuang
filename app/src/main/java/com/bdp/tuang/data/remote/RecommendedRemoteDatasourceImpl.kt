package com.bdp.tuang.data.remote

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.response_model.RecommendedResponseModel
import retrofit2.Response
import javax.inject.Inject

class RecommendedRemoteDatasourceImpl  @Inject constructor(
    val service: TuangService
) :
    RecommendedRemoteDatasource {
    override suspend fun getRecommended(): Response<RecommendedResponseModel> {
        return service.getRecommended()
    }


}