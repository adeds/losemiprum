package id.adeds.losemiprum.viewmodel

import id.adeds.model.model.User

sealed class HomeViewState

object Initial : HomeViewState()
object Loading : HomeViewState()
class Error(val errorMessage: String?) : HomeViewState()
data class UserReady(val data: User) : HomeViewState()
