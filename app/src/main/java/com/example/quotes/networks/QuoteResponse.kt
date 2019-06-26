package com.example.quotes

import com.google.gson.annotations.SerializedName

interface ApiResponse

class QuoteResponse(
    @SerializedName("quoteText")
    val quotes: String,
    @SerializedName("quoteAuthor")
    val author: String
) : ApiResponse