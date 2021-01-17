package com.woobok.a4_2_customlistview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("문자열1", "문자열2", "문자열3", "문자열4", "문자열5", "문자열6", "문자열7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, R.layout.row, R.id.rowTextView, data1)
        list1.adapter = adapter1

        list1.setOnItemClickListener { parent, view, position, id ->
            textView.text = "${data1[position]}을 터치함"
        }
    }
}