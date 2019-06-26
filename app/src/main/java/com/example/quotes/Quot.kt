package com.example.quotes

class Quot {

    private var quotes: String = ""
    private var author: String = ""

    constructor(){
        this.quotes = quotes
        this.author = author
    }

    val getQuotes: String
        get() = quotes

    val getAuthor: String
        get() = author

    var setQuotes: String = "defaultValue"
        set(value) {
            quotes = value
        }

    var setAuthor: String = "defaultValue"
        set(value) {
            author = value
        }
}