package com.example.quotes

import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("?method=getQuote&format=json&lang=ru")
    fun getQuote(): Call<QuoteResponse>
}