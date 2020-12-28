package com.woobok.a3_7_checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            textView.text = ""
            if (checkBox.isChecked) textView.append("첫 번째 체크 박스가 체크되어 있습니다.\n")
            else textView.append("첫 번째 체크 박스가 해제되어 있습니다.\n")
            if (checkBox2.isChecked) textView.append("두 번째 체크 박스가 체크되어 있습니다.\n")
            else textView.append("두 번째 체크 박스가 해제되어 있습니다.\n")
            if (checkBox3.isChecked) textView.append("세 번째 체크 박스가 체크되어 있습니다.\n")
            else textView.append("세 번째 체크 박스가 해제되어 있습니다.\n")
        }

        button2.setOnClickListener {
            checkBox.isChecked = true
            checkBox2.isChecked = true
            checkBox3.isChecked = true
        }

        button3.setOnClickListener {
            checkBox.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
        }

        button4.setOnClickListener {
            checkBox.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }

        checkBox.setOnCheckedChangeListener(listener1)
        checkBox2.setOnCheckedChangeListener(listener1)
        checkBox3.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) textView.text = "세 번째 체크 박스 체크"
            else textView.text = "세 번째 체크 박스 해제"
        }
    }

    val listener1 = object: CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when(buttonView?.id){
                R.id.checkBox -> {
                    if (isChecked) textView.text = "첫 번째 체크 박스 체크"
                    else textView.text = "첫 번째 체크 박스 해제"
                }
                R.id.checkBox2 -> {
                    if (isChecked) textView.text = "두 번째 체크 박스 체크"
                    else textView.text = "두 번째 체크 박스 해제"
                }
            }
        }
    }
}



