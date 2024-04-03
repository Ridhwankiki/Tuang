package com.bdp.tuang.data.remote

import com.bdp.tuang.data.response_model.RecommendedResponseModel
import retrofit2.Response

interface RecommendedRemoteDatasource {
    suspend fun getRecommended() : Response<RecommendedResponseModel>
}