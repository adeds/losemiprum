package id.adeds.losemiprum.viewmodel

import co.zsmb.rainbowcake.withIOContext
import id.adeds.core.interactor.UserInteractor
import javax.inject.Inject

class HomePresenter @Inject constructor(private val userInteractor: UserInteractor) {

    suspend fun getData() = withIOContext {
        userInteractor.getUserInfo()
    }
}
