package id.adeds.losemiprum.navigation

import id.adeds.core.loader.*
import javax.inject.Inject

interface Navigator<out FEATURE : Feature<*>> {
    fun isFeatureInstalled(): Boolean
    fun getFeature(): FEATURE
}

class HomeModule @Inject constructor(
    private val featureManager: FeatureManager,
    private val inboxDependencies: HomeFeature.Dependencies
) : Navigator<HomeFeature> {
    override fun isFeatureInstalled(): Boolean {
        return featureManager.isFeatureInstalled<HomeFeature>()
    }

    override fun getFeature(): HomeFeature {
        return featureManager.getFeature(inboxDependencies)!!
    }
}
