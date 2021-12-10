package com.elieomatuku.compositepatternarticle.leaf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elieomatuku.compositepatternarticle.R
import com.elieomatuku.compositepatternarticle.component.PortfolioComponentView
import com.elieomatuku.domain.component.PortfolioComponent


/**
 * Created by elieomatuku on 2021-11-15
 */

class PortfolioLeafFragment : Fragment(), PortfolioComponentView {
    companion object {
        const val PORTFOLIO_KEY = "portfolio"

        fun newInstance(portfolioComponent: PortfolioComponent): PortfolioLeafFragment {
            val fragment = PortfolioLeafFragment()
            val args = Bundle()
            args.putSerializable(PORTFOLIO_KEY, portfolioComponent)
            fragment.arguments = args
            return fragment
        }
    }

    override lateinit var portfolioComponent: PortfolioComponent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_portfolio_leaf, container, false)
        portfolioComponent = arguments?.getSerializable(PORTFOLIO_KEY) as PortfolioComponent

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.portfolio_owner_view).text = "Owners: ${
            portfolioComponent.getOwners().joinToString { "${it.name} ${it.lastName}" }
        }"
        view.findViewById<TextView>(R.id.portfolio_name_view).text =
            "Portfolio Name: ${portfolioComponent.getName()}"
        view.findViewById<TextView>(R.id.portfolio_value_view).text =
            "Worth: ZAR ${portfolioComponent.getValue()}"

        val assetRV = view.findViewById<RecyclerView>(R.id.assets_view)
        val assetAdapter = AssetAdapter(portfolioComponent.getAssets())
        assetRV.layoutManager = LinearLayoutManager(requireContext())
        assetRV.adapter = assetAdapter
        assetAdapter.notifyDataSetChanged()
    }

    override fun obtainView(): Fragment {
        return this
    }

}