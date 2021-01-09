package com.woobok.a4_8_autocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
            "abca", "abcb", "abcc", "abcd", "bbaa", "abc", "bcab", "bdab"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data1)
        autoCompleteTextView.setAdapter(adapter1)

        button.setOnClickListener {
            textView.text = "${autoCompleteTextView.text} 가 입력됨"
        }

        autoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
            val vv = view as TextView
            textView2.text = "${vv.text} 항목을 클릭함"
        }
    }
}