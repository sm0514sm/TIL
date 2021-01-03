package com.woobok.a3_11_chop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        chip1.setOnClickListener { 
            textView.text = "첫 번째 chip 을 클릭"

            if (chip2.isChecked)
                textView.append("두 번째 Chip 이 선택 됨\n")
            else
                textView.append("두 번째 Chip 이 선택 안됨\n")

            if (chip3.isChecked)
                textView.append("세 번째 Chip 이 선택 됨\n")
            else
                textView.append("세 번째 Chip 이 선택 안됨\n")

            if (chip4.isChecked)
                textView.append("네 번째 Chip 이 선택 됨\n")
            else
                textView.append("네 번째 Chip 이 선택 안됨\n")

            when (chipGroup1.checkedChipId) {
                R.id.chip6 -> textView.append("그룹 내의 첫번째 chip이 선택")
                R.id.chip7 -> textView.append("그룹 내의 두번째 chip이 선택")
                R.id.chip8 -> textView.append("그룹 내의 세번째 chip이 선택")
            }
        }

        chip3.setOnClickListener {
            textView.text = "세 번째 Chip 을 클릭"
        }

        chip3.setOnCloseIconClickListener {
            textView.text = "닫기 버튼을 누름"
        }

        chip4.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) textView.text = "네 번째 Chip 이 체크 됨\n"
            else textView.text = "네 번째 Chip 이 체크 안됨\n"
        }
    }
}