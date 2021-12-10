package com.elieomatuku.compositepatternarticle.client

import androidx.lifecycle.*
import com.elieomatuku.compositepatternarticle.component.toPortfolioComponentView
import com.elieomatuku.data.PortfolioRepositoryImpl
import com.elieomatuku.domain.client.usecase.GetUserPortfolio
import kotlinx.coroutines.launch


/**
 * Created by elieomatuku on 2021-11-15
 */

class PortfolioViewModel : ViewModel() {

    private val getUserSinglePortfolio = GetUserPortfolio(PortfolioRepositoryImpl())

    val state =
        MediatorLiveData<PortfolioViewState>().apply { value = PortfolioViewState() }

    fun getUserPortfolio(userId: String) {
        state.value = PortfolioViewState(isLoading = true)
        viewModelScope.launch {
            val portfolio = getUserSinglePortfolio.execute(GetUserPortfolio.Input(userId))
            state.value = PortfolioViewState(portfolioView = portfolio.toPortfolioComponentView())
        }
    }

}