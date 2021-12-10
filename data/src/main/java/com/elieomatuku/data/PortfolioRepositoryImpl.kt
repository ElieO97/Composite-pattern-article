package com.elieomatuku.data

import com.elieomatuku.domain.other_entities.*
import com.elieomatuku.domain.client.repostory.PortfolioRepository
import com.elieomatuku.domain.component.PortfolioComponent
import com.elieomatuku.domain.composite.PortfolioComposite
import com.elieomatuku.domain.leaf.PortfolioLeaf
import kotlinx.coroutines.delay

class PortfolioRepositoryImpl : PortfolioRepository {

    override suspend fun getUserPortfolio(userId: String): PortfolioComponent {
        delay(500)

        return when (userId) {
            "1234" -> {
                getSinglePortfolio()
            }
            "12345" -> {
                getMultiplePortfolio()
            }
            else -> {
                getSinglePortfolio()
            }
        }
    }

    private fun getSinglePortfolio(): PortfolioComponent {
        val personalPortfolio = PortfolioLeaf(
            listOf(Owner("Jean", "Kasongo")),
            "Personal Portfolio",
            listOf(
                Asset("Land in Lubumbashi", 25000.0),
                Asset("Cars", 240000.0),
                Asset("House in Lubumbashi", 1000000.0),
                Asset("Coffee Shop", 100000.0)
            )
        )

        return PortfolioComposite(
            owners = listOf(Owner("Jean", "Kasongo")),
            children = listOf(
                personalPortfolio
            )
        )
    }

    private fun getMultiplePortfolio(): PortfolioComponent {
        val personalPortfolio = PortfolioLeaf(
            listOf(Owner("Jean", "Kasongo")),
            "Personal Portfolio",
            listOf(
                Asset("Land in Lubumbashi", 25000.0),
                Asset("Cars", 240000.0),
                Asset("House in Lubumbashi", 1000000.0),
                Asset("Coffee Shop", 100000.0)
            )
        )

        val familyPortfolio = PortfolioLeaf(
            listOf(
                Owner("Jean", "Kasongo"),
                Owner("Judith", "Kasongo"),
                Owner("Martin", "Kasongo")
            ),
            "Family Portfolio",
            listOf(
                Asset("Stocks", 2500000.0),
                Asset("Cars", 540000.0),
                Asset("Family House in Lubumbashi", 2000000.0),
                Asset("Clothing Stores", 1000000.0)
            )
        )

        return PortfolioComposite(
            owners = listOf(Owner("Jean", "Kasongo")),
            children = listOf(
                personalPortfolio,
                familyPortfolio
            )
        )
    }
}