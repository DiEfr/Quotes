package com.example.quotes

class Quotes {
    private var quotes: String = ""
    private var author: String = ""

    constructor(
        quotes: String,
        author: String
    ) {
        this.quotes = quotes
        this.author = author
    }

    val getQuotes: String
        get() = quotes

    val getAuthor: String
        get() = author
}