package com.elieomatuku.data

import com.elieomatuku.domain.other_entities.*
import com.elieomatuku.domain.client.repostory.PortfolioRepository
import com.elieomatuku.domain.component.PortfolioComponent
import com.elieomatuku.domain.composite.PortfolioComposite
import com.elieomatuku.domain.leaf.PortfolioLeaf
import kotlinx.coroutines.delay

class PortfolioRepositoryImpl : PortfolioRepository {

    override suspend fun getUserSinglePortfolio(userId: String): PortfolioComponent {
        delay(500)
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

    override suspend fun getUserMultiplePortfolio(userId: String): PortfolioComponent {
        delay(500)
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