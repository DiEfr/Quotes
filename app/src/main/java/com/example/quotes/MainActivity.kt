package com.example.quotes

import android.os.Bundle

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.util.Log
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {

    var dbHelper: DBHelper = DBHelper(this)
     var quotes: String? = null
     var author: String? = null

    var database: SQLiteDatabase? = null
    var contentValues = ContentValues()

    var sendButton: Button? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_share -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.action_home -> {

                textQuot2.setText(quotes)
                textAth2.setText(author)

                return@OnNavigationItemSelectedListener true
            }
            R.id.action_menu -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        getQuote()
        setContentView(R.layout.activity_main)

        //val database: SQLiteDatabase = dbHelper.writableDatabase


        database = dbHelper.writableDatabase

        read()

        sendButton = findViewById(R.id.izbr)
        sendButton?.setOnClickListener(View.OnClickListener { View->onClickSendButton() })

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }

    private fun onClickSendButton() {


    }

    private fun read() {
        val cursor = database?.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null)

        if (cursor?.moveToFirst()!!) {
            val idIndex = cursor?.getColumnIndex(DBHelper.KEY_ID)
            val quoteIndex = cursor?.getColumnIndex(DBHelper.KEY_QUOTES)
            val authorIndex = cursor?.getColumnIndex(DBHelper.KEY_AUTHOR)
            do {
                Log.d(
                    "mLog", "ID = " + cursor?.getInt(idIndex) +
                            ", quote = " + cursor?.getString(quoteIndex) +
                            ", author = " + cursor?.getString(authorIndex)
                )
                quotes = cursor?.getString(quoteIndex)
                author = cursor?.getString(authorIndex)
            } while (cursor?.moveToNext())
        } else
            Log.d("mLog", "0 rows")

        cursor.close()
    }

    private fun getQuote(){
        Repository.instance.getQuotes(object : ResponseCallback<QuoteResponse> {
            override fun onSuccess(apiResponse: QuoteResponse) {
                val quote = Quotes(apiResponse.quotes, apiResponse.author)

                contentValues.put(DBHelper.KEY_QUOTES, quote.getQuotes)
                contentValues.put(DBHelper.KEY_AUTHOR, quote.getAuthor)
                contentValues.put(DBHelper.KEY_FAVORITES, 0)

                database?.insert(DBHelper.TABLE_CONTACTS, null, contentValues)

            }

            override fun onFailure(errorMessage: String) {
            }

        })
    }
}


/*Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment_image);*/