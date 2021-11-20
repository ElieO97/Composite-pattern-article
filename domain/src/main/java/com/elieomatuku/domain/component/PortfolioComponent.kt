package com.elieomatuku.domain.component

import com.elieomatuku.domain.other_entities.Asset
import com.elieomatuku.domain.other_entities.Owner
import java.io.Serializable


/**
 * Created by elieomatuku on 2021-11-15
 */

interface PortfolioComponent: Serializable {

    fun getName(): String

    fun getOwners(): List<Owner>

    fun getAssets(): List<Asset>

    fun getValue(): Double
}