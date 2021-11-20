package com.elieomatuku.compositepatternarticle.client

import com.elieomatuku.compositepatternarticle.component.PortfolioComponentView

/**
 * Created by elieomatuku on 2021-11-15
 */

data class PortfolioViewState(
    val portfolioView: PortfolioComponentView? = null,
    val isLoading: Boolean = false,
    val isError: String? = null
)
