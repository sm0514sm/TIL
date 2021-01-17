package com.woobok.a3_6_togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if(toggleButton.isChecked){
                textView.text = "On 상태 다용"
            }else{
                textView.text = "Off 상태 다용"
            }
        }
        button2.setOnClickListener {
            toggleButton.isChecked = true
        }
        button3.setOnClickListener {
            toggleButton.isChecked = false
        }
        button4.setOnClickListener {
            toggleButton.toggle()
        }
        toggleButton.setOnClickListener(listener)
        toggleButton.setOnClickListener {
            if(toggleButton.isChecked) textView2.text = "On 상태 다용"
            else textView2.text = "Off 상태 다용"
        }
    }

    val listener = object: View.OnClickListener {
        override fun onClick(v: View?) {
            if(toggleButton.isChecked) textView.text = "On 상태 다용"
            else textView.text = "Off 상태 다용"
        }
    }
}