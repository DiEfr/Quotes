package com.example.quotes

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private object Holder {
        val INSTANCE = Repository()
    }

    companion object {
        val instance: Repository by lazy { Holder.INSTANCE }
    }

    fun getQuotes(responseCallback: ResponseCallback<QuoteResponse>) {
        /*async data acquisition*/
        NetworkService.instance.service.getQuote().enqueue(object : Callback<QuoteResponse> {
            override fun onFailure(call: Call<QuoteResponse>, t: Throwable) {
                responseCallback.onFailure("Getting cities error")
            }

            override fun onResponse(
                call: Call<QuoteResponse>,
                response: Response<QuoteResponse>
            ) {
                val citiesResponse = response.body()

                if (citiesResponse != null && response.isSuccessful) {
                    responseCallback.onSuccess(citiesResponse)//take the parsed data
                } else {
                    responseCallback.onFailure("Getting cities error")
                }
            }
        })
    }
}