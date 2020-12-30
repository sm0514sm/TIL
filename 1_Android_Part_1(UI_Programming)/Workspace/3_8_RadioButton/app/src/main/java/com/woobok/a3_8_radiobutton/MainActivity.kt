package com.woobok.a3_8_radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            radioButton3.isChecked = true
            radioButton6.isChecked = true
        }

        button2.setOnClickListener {
            when(radioGroup1.checkedRadioButtonId){
                R.id.radioButton -> {
                    textView.text = "라디오 1-1 이 체크됨"
                }
                R.id.radioButton2 -> {
                    textView.text = "라디오 1-2 이 체크됨"
                }
                R.id.radioButton3 -> {
                    textView.text = "라디오 1-3 이 체크됨"
                }
            }

            when(radioGroup2.checkedRadioButtonId){
                R.id.radioButton4 -> {
                    textView2.text = "라디오 2-1 이 체크됨"
                }
                R.id.radioButton5 -> {
                    textView2.text = "라디오 2-2 이 체크됨"
                }
                R.id.radioButton6 -> {
                    textView2.text = "라디오 2-3 이 체크됨"
                }
            }
        }

        radioGroup1.setOnCheckedChangeListener(listener1)
        radioGroup2.setOnCheckedChangeListener { group, checkedID ->
            when(checkedID){
                R.id.radioButton4 -> textView2.text = "라디오 2-1 가 체크됨"
                R.id.radioButton5 -> textView2.text = "라디오 2-2 가 체크됨"
                R.id.radioButton6 -> textView2.text = "라디오 2-3 가 체크됨"
            }
        }
    }

    val listener1 = object: RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(group: RadioGroup?, checkedID: Int) {
            when(group?.id) {   // 체크 이벤트의 라디오 그룹 아이디
                R.id.radioGroup1 -> {
                    when(checkedID){
                        R.id.radioButton -> textView.text = "라디오 1-1 가 체크됨"
                        R.id.radioButton2 -> textView.text = "라디오 1-2 가 체크됨"
                        R.id.radioButton3 -> textView.text = "라디오 1-3 가 체크됨"
                    }
                }
            }
        }
    }
}