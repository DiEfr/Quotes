package com.example.quotes

import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_image.*


class MainActivity : AppCompatActivity() {

    private var quotes: String? = null
    private var author: String? = null

    /*fun getQuotes(): String? {
        return this.quotes
    }
    fun getAuthor(): String? {
        return this.author
    }*/

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_share -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.action_home -> {
/* val fatherView=FatherPresentation()
        addFragment(fatherView,R.id.container)*/
                /*val frag2 = fragment_main()
                addFragment(frag2,R.id.container)*/

              /*  qu.text = quotes
                aff.text = author*/

                return@OnNavigationItemSelectedListener true
            }
            R.id.action_menu -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        getQuote()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewpager)



        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


    }

    private fun getQuote(){
        Repository.instance.getQuotes(object : ResponseCallback<QuoteResponse> {
            override fun onSuccess(apiResponse: QuoteResponse) {
                val quote = Quotes(apiResponse.quotes, apiResponse.author)
                quotes = quote.getQuotes
                author = quote.getAuthor
            }

            override fun onFailure(errorMessage: String) {
            }

        })
    }
}
/*Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment_image);*/