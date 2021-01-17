package kr.co.softcampus.aswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        button.setOnClickListener { 
            if(switch1.isChecked == true){
                textView.text = "ON 상태입니다"
            } else {
                textView.text = "OFF 상태입니다"
            }
        }

        button2.setOnClickListener {
            switch1.isChecked = true
        }

        button3.setOnClickListener {
            switch1.isChecked = false
        }

        switch1.setOnCheckedChangeListener(listener1)

        switch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked == true){
                textView2.text = "두 번째 스위치가 ON 상태가 되었습니다"
            } else {
                textView2.text = "두 번째 스위치가 OFF 상태가 되었습니다"
            }
        }
    }

    val listener1 = object : CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when(buttonView?.id){
                R.id.switch1 -> {
                    if(isChecked == true){
                        textView.text = "첫 번째 스위치가 ON 상태가 되었습니다"
                    } else {
                        textView.text = "첫 번째 스위치가 OFF 상태가 되었습니다"
                    }
                }
            }
        }
    }
}














