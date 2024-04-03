package com.bdp.tuang.data.remote

import com.bdp.tuang.data.TuangService
import com.bdp.tuang.data.response_model.JapaneseResponseModel
import retrofit2.Response
import javax.inject.Inject

class JapaneseRemoteDatasourceImpl  @Inject constructor(
    val service: TuangService
) :
    JapaneseRemoteDatasource {
    override suspend fun getJapanese(): Response<JapaneseResponseModel> {
        return service.getJapanese()
    }


}