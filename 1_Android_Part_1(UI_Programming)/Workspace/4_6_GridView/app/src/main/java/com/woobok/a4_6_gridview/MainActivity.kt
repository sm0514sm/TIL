package com.woobok.a4_6_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
        "그리드1", "그리드2", "그리드3", "그리드4", "그리드5",
        "그리드6", "그리드7", "그리드8", "그리드9", "그리드10",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        grid1.adapter = adapter1
        grid1.setOnItemClickListener { adapterView, view, i, l ->
            textView.text = "${data1[i]} 번째 아이템을 클릭했습니다."
        }
    }
}