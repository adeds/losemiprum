/*
 * Copyright (c) 2020.
 * PT. Sampingan Mitra Indonesia
 */

package id.adeds.home.di

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import id.adeds.core.loader.HomeFeature
import id.adeds.home.HomeFragment

@AutoService(HomeFeature::class)
class HomeFeatureImpl : HomeFeature {
    override fun getMainScreen(name: String): Fragment {
        return when (name) {
            HomeFeature.HOME_FRAGMENT -> HomeFragment()
            else -> throw IllegalArgumentException("Unexpected fragment: $name")
        }
    }

    override fun getLaunchIntent(context: Context, name: String): Intent {
        return throw IllegalArgumentException("Unexpected activity/intent: $name")
    }

    override fun inject(dependencies: HomeFeature.Dependencies) {
//        TODO("Implement if this Modules needs dependencies from base / other DFM")
    }
}