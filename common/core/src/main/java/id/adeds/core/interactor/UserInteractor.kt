package id.adeds.core.interactor

import id.adeds.core.api.UserApi
import id.adeds.model.model.User

class UserInteractor(private val userApi: UserApi /*, val userDao: UserDao*/) {
    suspend fun getUserInfo(): User {
        return userApi.getUserInfo()
    }
}