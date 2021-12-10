package com.elieomatuku.compositepatternarticle.composite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.elieomatuku.compositepatternarticle.R
import com.elieomatuku.compositepatternarticle.component.PortfolioComponentView
import com.elieomatuku.compositepatternarticle.component.toPortfolioComponentView
import com.elieomatuku.compositepatternarticle.leaf.PortfolioLeafFragment
import com.elieomatuku.domain.component.PortfolioComponent
import com.elieomatuku.domain.composite.PortfolioComposite

/**
 * Created by elieomatuku on 2021-11-15
 */

class PortfolioCompositeFragment : Fragment(), PortfolioComponentView {
    companion object {
        private const val PORTFOLIO_KEY = "portfolio"
        fun newInstance(
            portfolioComponent: PortfolioComponent
        ): PortfolioCompositeFragment {
            val fragment = PortfolioCompositeFragment()
            val args = Bundle()
            args.putSerializable(PORTFOLIO_KEY, portfolioComponent)
            fragment.arguments = args
            return fragment
        }
    }

    override lateinit var portfolioComponent: PortfolioComponent
    lateinit var children: List<PortfolioComponentView>

    private val searchAdapter by lazy {
        PortfolioCompositeAdapter(checkNotNull(this))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        portfolioComponent =
            arguments?.getSerializable(PortfolioLeafFragment.PORTFOLIO_KEY) as PortfolioComponent
        children =
            (portfolioComponent as PortfolioComposite).children.map { it.toPortfolioComponentView() }
        return inflater.inflate(R.layout.fragment_portfolio_composite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val treatmentView = view.findViewById<TextView>(R.id.multiple_portfolio_treatment)
        if (children.size > 1) {
            treatmentView.text =
                "A portfolio composed of: ${portfolioComponent.getName()}\n\nWorth: ZAR ${portfolioComponent.getValue()}\n\nOwners: ${
                    portfolioComponent.getOwners().joinToString { "${it.name} ${it.lastName}" }
                }"
            treatmentView.isVisible = true
        }

        val viewPager = view.findViewById<ViewPager2>(R.id.viewpager)
        viewPager.adapter = searchAdapter
    }

    override fun obtainView(): Fragment {
        return this
    }
}