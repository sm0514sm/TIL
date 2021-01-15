package com.woobok.a4_9_multiautocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data = arrayOf(
            "abcd", "acb", "adbc", "vvcd", "cedw", "bbbbb"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data)

        // 구분자 설정
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        multiAutoCompleteTextView.setAdapter(adapter1)


        button.setOnClickListener {
            // , 를 기준으로 자르기
            val strArray = multiAutoCompleteTextView.text.split(",")

            textView.text = ""
            for (str in strArray){
                if (str.trim() != ""){ // 빈문자열이 아니라면
                    textView.append("${str.trim()}\n")
                }
            }
        }
        multiAutoCompleteTextView.setOnItemClickListener { adapterView, view, i, l ->
            val vv = view as TextView
            textView2.text = "${vv.text} 항목을 클릭함"
        }
    }
}