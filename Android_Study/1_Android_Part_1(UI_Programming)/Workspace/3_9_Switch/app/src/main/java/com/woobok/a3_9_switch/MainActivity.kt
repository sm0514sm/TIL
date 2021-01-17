package com.woobok.a3_9_switch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (switch1.isChecked)  textView.text = "On 상태"
            else textView.text = "Off 상태"
        }

        button2.setOnClickListener {
            switch1.isChecked = true
        }

        button3.setOnClickListener {
            switch1.isChecked = false
        }

        switch1.setOnCheckedChangeListener(listener1)
        switch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) textView2.text = "첫 번째 스위치가 On"
            else textView2.text = "두 번째 스위치가 Off"
        }
    }

    val listener1 = object: CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when(buttonView?.id){
                R.id.switch1 -> {
                    if (isChecked) textView.text = "첫 번째 스위치가 On"
                    else textView.text = "두 번째 스위치가 Off"
                }
            }
        }
    }
}