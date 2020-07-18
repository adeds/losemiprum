package id.adeds.data.api

import id.adeds.model.User
import retrofit2.http.GET

interface UserApi {

    @GET("users/1")
    suspend fun getUserInfo(): User
}