/*
 * Copyright (c) 2020.
 * PT. Sampingan Mitra Indonesia
 */

package id.adeds.core.loader

import android.content.Context
import android.content.Intent
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

fun <T : Feature<*>> KClass<T>.info() = when (this) {
    HomeFeature::class -> Feature.Info(
        name = HomeFeature.HOME_ID,
        actionId = HomeFeature.HOME_ID.hashCode()
    )

    else -> throw IllegalArgumentException("Unexpected feature $this")
}

interface Feature<T> {
    fun getMainScreen(name: String): Fragment
    fun getLaunchIntent(context: Context, name: String = ""): Intent
    fun inject(dependencies: T)

    data class Info(
        @IdRes val actionId: Int,
        val name: String // e.g: ":features:inbox", put "inbox" here
    )
}

interface HomeFeature : Feature<HomeFeature.Dependencies> {
    companion object {
        const val HOME_ID = "home"

        const val HOME_FRAGMENT = "HOME_FRAGMENT"
    }

    interface Dependencies
}