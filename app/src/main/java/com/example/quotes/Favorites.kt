package com.example.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

class Favorites: AppCompatActivity() {

    fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {


        return inflater!!.inflate(R.layout.activity_menu, container, false)
        //return layoutInflater.inflate(R.layout.activity_quotes)
    }
}