package com.example.products.ui.view

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.products.R
import com.example.products.data.model.ProductModelResponse
import com.example.products.data.model.Records
import com.example.products.data.model.UIState
import com.example.products.databinding.ActivityMainBinding
import com.example.products.ui.adapter.MainActivityAdapter
import com.example.products.ui.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    private var list: List<Records> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.initView()

    }

    private fun initView() {
        this.servicesResponse()
        this.radiobutton()
        this.viewModel.getProductService("")
        this.searView(binding.SearchView)
        this.observer()
    }

    private fun radiobutton() {
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.rbPreference == checkedId) {
                this.viewModel.getProductService("")
            } else if (R.id.rbMajor == checkedId) {
                this.viewModel.getProductService("0")
            } else {
                this.viewModel.getProductService("1")
            }
        }
    }

    private fun observer() {
        this.viewModel.isLoading.observe(this) {
            binding.progress.isVisible = it
        }
    }

    private fun searView(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?) = false
            override fun onQueryTextChange(newtex: String?): Boolean {
                val listNew =
                    if (newtex!!.isNotEmpty()) {
                        list.filter { it.productDisplayName!!.contains(newtex, true) }
                    } else {
                        list
                    }

                rv(listNew)
                return false
            }
        })
    }

    private fun servicesResponse() {
        lifecycleScope.launchWhenStarted {
            viewModel.lsfResponse.collect { state ->
                when (state) {
                    is UIState.Success<*> -> {
                        when (state.entity) {
                            is ProductModelResponse -> productResponse(state.entity)
                        }
                    }
                    is UIState.Error -> errorResponse(state.message)
                    is UIState.IsEmpty -> Unit
                }
            }
        }
    }

    private fun productResponse(entity: ProductModelResponse) {
        list = entity.plpResults!!.records
        rv(list)
    }

    private fun rv(list: List<Records>) {
        this.binding.rvProduct.apply {
            hasFixedSize()
            adapter = MainActivityAdapter(list)
        }
    }

    private fun errorResponse(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}