package id.adeds.data.interactor

import id.adeds.data.api.UserApi
import id.adeds.model.User


class UserInteractor(private val userApi: UserApi /*, val userDao: UserDao*/) {
    suspend fun getUserInfo(): User {
        return userApi.getUserInfo()
    }
}