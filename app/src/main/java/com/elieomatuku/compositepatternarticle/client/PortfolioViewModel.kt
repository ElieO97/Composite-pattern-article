package com.elieomatuku.compositepatternarticle.client

import androidx.lifecycle.*
import com.elieomatuku.compositepatternarticle.component.toPortfolioComponentView
import com.elieomatuku.data.PortfolioRepositoryImpl
import com.elieomatuku.domain.client.usecase.GetUserMultiplePortfolio
import com.elieomatuku.domain.client.usecase.GetUserSinglePortfolio
import kotlinx.coroutines.launch


/**
 * Created by elieomatuku on 2021-11-15
 */

class PortfolioViewModel : ViewModel() {

    private val getUserSinglePortfolio = GetUserSinglePortfolio(PortfolioRepositoryImpl())
    private val getUserMultiplePortfolio = GetUserMultiplePortfolio(PortfolioRepositoryImpl())

    val state =
        MediatorLiveData<PortfolioViewState>().apply { value = PortfolioViewState() }

    fun getUserSinglePortfolio() {
        state.value = PortfolioViewState(isLoading = true)
        viewModelScope.launch {
            val portfolio = getUserSinglePortfolio.execute()
            state.value = PortfolioViewState(portfolioView = portfolio.toPortfolioComponentView())
        }
    }

    fun getUserMultiplePortfolio() {
        state.value = PortfolioViewState(isLoading = true)
        viewModelScope.launch {
            val portfolio = getUserMultiplePortfolio.execute()
            state.value = PortfolioViewState(portfolioView = portfolio.toPortfolioComponentView())
        }
    }
}