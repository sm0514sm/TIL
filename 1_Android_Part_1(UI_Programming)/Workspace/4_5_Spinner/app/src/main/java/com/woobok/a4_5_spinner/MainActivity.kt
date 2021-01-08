package com.woobok.a4_5_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 접혔을 때 모습 구성할 Layout 설정 Adapter
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
        // 펼쳤을 때 모습 구성할 Layout 설정 Adapter
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter1

        button.setOnClickListener {
            textView.text = "선택한 항목 ${data1[spinner.selectedItemPosition]}"
        }

        spinner.onItemSelectedListener = listener1
    }

    val listener1 = object: AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id){
                R.id.spinner -> textView.text = "${data1[position]} 번 째 항목이 선택되었다."
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
    }
}