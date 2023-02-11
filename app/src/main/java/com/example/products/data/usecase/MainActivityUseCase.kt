package com.example.products.data.usecase

import com.example.products.data.model.ProductModelResponse
import com.example.products.data.repository.ApiRepository
import javax.inject.Inject

class MainActivityUseCase @Inject constructor(private val apiRepository: ApiRepository) {

    suspend fun getProductUseCase(type: String) =
        apiRepository.apiRepository<ProductModelResponse>("plp", "3", type)
}