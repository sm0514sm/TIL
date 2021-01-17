package kr.co.softcampus.togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { 
            if(toggleButton.isChecked == true){
                textView.text = "ON 상태 입니다"
            } else {
                textView.text = "OFF 상태 입니다"
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

        toggleButton2.setOnClickListener {
            if(toggleButton2.isChecked == true){
                textView2.text = "ON 상태로 설정되었습니다"
            } else {
                textView2.text = "OFF 상태로 설정되었습니다"
            }
        }
    }
    
    val listener = object : View.OnClickListener{
        override fun onClick(v: View?) {
            if(toggleButton.isChecked == true){
                textView.text = "ON 상태로 설정되었습니다"
            } else {
                textView.text = "OFF 상태로 설정되었습니다"
            }
        }
    }
}










