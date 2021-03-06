package com.woobok.a3_2_button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 버튼에 리스너를 설정
        button1.setOnClickListener(listener1)
        imageButton1.setOnClickListener(listener2)
        button2.setOnClickListener(listener3)
        button3.setOnClickListener(listener3)
        
        button4.setOnClickListener { 
            text1.text = "다섯번째 버튼을 눌렀습니다"
        }
    }

    // 버튼을 클릭하면 동작하는 리스너 객체
    val listener1 = object : View.OnClickListener{
        override fun onClick(v: View?) {
            text1.text = "첫 번째 버튼 클릭됨!!"
        }
    }

    val listener2 = object : View.OnClickListener{
        override fun onClick(v: View?) {
            text1.text = "이미지 버튼 클릭됨!!"
        }
    }

    val listener3 = object : View.OnClickListener {
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.button2 -> {
                    text1.text = "두번째 버튼을 눌렀습니다"
                }
                R.id.button3 -> {
                    text1.text = "세번째 버튼을 눌렀습니다."
                }
            }
        }
    }
}