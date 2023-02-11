package com.example.products.core.network

import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("{url}")
    suspend fun getServiceCoroutine(
        @Path(value = "url", encoded = true) url: String,
        @Query("page-number") language: String
    ): Response<Any>

    @GET("{url}")
    suspend fun getServiceCoroutineMajor(
        @Path(value = "url", encoded = true) url: String,
        @Query("page-number") language: String,
        @Query("minSortPrice") minSortPrice: String,
    ): Response<Any>
}