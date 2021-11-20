package com.elieomatuku.compositepatternarticle.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.elieomatuku.compositepatternarticle.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PortfolioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            ).get(
                PortfolioViewModel::class.java
            )

        viewModel.getUserSinglePortfolio()

        val loadingView = findViewById<ProgressBar>(R.id.loading_view)
        viewModel.state.observe(this) {
            loadingView.isVisible = it.isLoading
            it.portfolioView?.let { view ->
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, view.obtainView())
                    .commit()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.portfolio_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_single_portfolio -> {
                viewModel.getUserSinglePortfolio()
            }

            R.id.action_multiple_portfolio -> {
                viewModel.getUserMultiplePortfolio()
            }
        }
        return true
    }
}