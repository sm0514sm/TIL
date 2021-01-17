package com.woobok.a3_10_checkedtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckedTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = ""
            if(checkedTextView.isChecked) textView.append("첫번째 체크 박스 체크되어 있음\n")
            else textView.append("첫번째 체크 박스 체크되어 있지 않음\n")

            if(checkedTextView2.isChecked) textView.append("두번째 체크 박스 체크되어 있음\n")
            else textView.append("두번째 체크 박스 체크되어 있지 않음\n")

            if(checkedTextView3.isChecked) textView.append("세번째 체크 박스 체크되어 있음\n")
            else textView.append("세번째 체크 박스 체크되어 있지 않음\n")

            when {
                checkedTextView4.isChecked -> textView.append("첫번째 라디오 박스 체크되어 있음\n")
                checkedTextView6.isChecked -> textView.append("두번째 라디오 박스 체크되어 있음\n")
                checkedTextView7.isChecked -> textView.append("세번째 라디오 박스 체크되어 있음\n")
            }
        }

        button2.setOnClickListener {
            checkedTextView.isChecked = false
            checkedTextView2.isChecked = true
            checkedTextView3.isChecked = false

            checkedTextView4.isChecked = false
            checkedTextView6.isChecked = false
            checkedTextView7.isChecked = true

        }

        checkedTextView.setOnClickListener(listener1)
        checkedTextView2.setOnClickListener(listener1)
        checkedTextView3.setOnClickListener(listener1)

        checkedTextView4.setOnClickListener(listener2)
        checkedTextView6.setOnClickListener(listener2)
        checkedTextView7.setOnClickListener(listener2)
    }

    val listener1 = object: View.OnClickListener {
        override fun onClick(v: View?) {
            // View 형태를 checkedTextView 형태로 형변환
            val obj = v as CheckedTextView
            obj.isChecked = !obj.isChecked
        }
    }

    val listener2 = object: View.OnClickListener {
        override fun onClick(v: View?) {
            checkedTextView4.isChecked = false
            checkedTextView6.isChecked = false
            checkedTextView7.isChecked = false

            val obj = v as CheckedTextView
            obj.isChecked = true
        }
    }
}