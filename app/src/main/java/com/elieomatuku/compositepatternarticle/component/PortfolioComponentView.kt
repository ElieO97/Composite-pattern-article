package com.elieomatuku.compositepatternarticle.component

import androidx.fragment.app.Fragment
import com.elieomatuku.compositepatternarticle.composite.PortfolioCompositeFragment
import com.elieomatuku.compositepatternarticle.leaf.PortfolioLeafFragment
import com.elieomatuku.domain.component.PortfolioComponent
import com.elieomatuku.domain.composite.PortfolioComposite
import com.elieomatuku.domain.leaf.PortfolioLeaf


/**
 * Created by elieomatuku on 2021-11-15
 */

interface PortfolioComponentView {

    var portfolioComponent: PortfolioComponent

    fun obtainView(): Fragment

}

fun PortfolioComponent.toPortfolioComponentView(): PortfolioComponentView {
    return when (this) {
        is PortfolioLeaf -> PortfolioLeafFragment.newInstance(this)
        is PortfolioComposite -> PortfolioCompositeFragment.newInstance(this)
        else -> throw RuntimeException("Unhandled Portfolio Type")
    }
}