package com.elieomatuku.domain.client.usecase

import com.elieomatuku.domain.component.PortfolioComponent
import com.elieomatuku.domain.client.repostory.PortfolioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by elieomatuku on 2021-11-15
 */

class GetUserMultiplePortfolio(private val portfolioRepository: PortfolioRepository) {

    suspend fun execute(): PortfolioComponent {
        return withContext(Dispatchers.IO) {
            this@GetUserMultiplePortfolio.portfolioRepository.getUserMultiplePortfolio("12345")
        }
    }
}