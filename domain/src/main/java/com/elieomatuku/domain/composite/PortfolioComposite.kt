package com.elieomatuku.domain.composite

import com.elieomatuku.domain.component.PortfolioComponent
import com.elieomatuku.domain.other_entities.Asset
import com.elieomatuku.domain.other_entities.Owner


/**
 * Created by elieomatuku on 2021-11-15
 */

data class PortfolioComposite(
    private val owners: List<Owner>,
    val children: List<PortfolioComponent>
) : PortfolioComponent {

    override fun getName(): String {
        return children.joinToString {
            it.getName()
        }
    }

    override fun getOwners(): List<Owner> {
        return owners
    }

    override fun getAssets(): List<Asset> {
        return children.map {
            it.getAssets()
        }.flatten()
    }

    override fun getValue(): Double {
        return children.map {
            it.getValue()
        }.sum()
    }
}
