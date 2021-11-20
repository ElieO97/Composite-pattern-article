package com.elieomatuku.domain.client.repostory

import com.elieomatuku.domain.component.PortfolioComponent


/**
 * Created by elieomatuku on 2021-11-15
 */

interface PortfolioRepository {

    suspend fun getUserSinglePortfolio(userId: String): PortfolioComponent
    suspend fun getUserMultiplePortfolio(userId: String): PortfolioComponent

}