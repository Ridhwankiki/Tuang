package com.bdp.tuang.data.remote

import com.bdp.tuang.data.response_model.JapaneseResponseModel
import retrofit2.Response

interface JapaneseRemoteDatasource {
    suspend fun getJapanese() : Response<JapaneseResponseModel>
}