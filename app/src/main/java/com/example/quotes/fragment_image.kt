package com.example.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_image.*


class fragmentImage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myClassA = MainActivity()

        /*textQuot.setText(myClassA.getQuotes())
        textAth.text = myClassA.getAuthor()*/

        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_image, container, false)
    }

}

