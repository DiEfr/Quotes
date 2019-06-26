package com.example.quotes

const val BASE_URL = "https://api.forismatic.com/api/1.0/"

interface ResponseCallback<R> {
    fun onSuccess(apiResponse: R)
    fun onFailure(errorMessage: String)
}