package id.adeds.core.api

import id.adeds.model.model.User
import retrofit2.http.GET

interface UserApi {

    @GET("users/1")
    suspend fun getUserInfo(): User
}