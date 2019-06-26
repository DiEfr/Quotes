package com.example.quotes

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

 class DBHelper(context:Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


     override fun onCreate(db: SQLiteDatabase) {
         db.execSQL(
             "create table " + TABLE_CONTACTS + "(" + KEY_ID
                     + " integer primary key," + KEY_QUOTES + " text," + KEY_AUTHOR + " text" +  KEY_FAVORITES + " text" + ")"
         )

     }

     override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
         db.execSQL("drop table if exists" + TABLE_CONTACTS)

         onCreate(db)

     }

     companion object {

        public const val DATABASE_VERSION = 1
        public const val DATABASE_NAME = "quotesDb"
        public const val TABLE_CONTACTS = "quotes"

         public const val KEY_ID = "_id"
         public const val KEY_QUOTES = "quotes"
         public const val KEY_AUTHOR = "author"
         public const val KEY_FAVORITES = "favorites"
     }
 }