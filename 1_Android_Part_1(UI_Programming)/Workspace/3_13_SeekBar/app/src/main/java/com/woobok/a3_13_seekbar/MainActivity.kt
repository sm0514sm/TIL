package com.woobok.a3_13_seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "SeekBar 1: ${seekBar.progress}"
            textView2.text = "SeekBar 2: ${seekBar3.progress}"
        }

        button2.setOnClickListener {
            seekBar3.progress = 8
            seekBar.progress = 3
        }

        button3.setOnClickListener {
            seekBar.incrementProgressBy(1)
            seekBar3.incrementProgressBy(1)
        }
        button4.setOnClickListener {
            seekBar.incrementProgressBy(-1)
            seekBar3.incrementProgressBy(-1)
        }

        seekBar.setOnSeekBarChangeListener(listener1)
        seekBar3.setOnSeekBarChangeListener(listener1)
    }

    val listener1 = object: SeekBar.OnSeekBarChangeListener{
        // ProgressBar 의 값이 변경되었을 때
        override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
            textView.text = ""
            when(seekbar?.id) {
                R.id.seekBar -> textView.text = "첫 번째 seekBar 가 ${progress}로 설정\n"
                R.id.seekBar3 -> textView.text = "두 번째 seekBar 가 ${progress}로 설정\n"
            }
            if (fromUser) // 사용자에 의한 건지
                textView.append("사용자에 의해 설정")
            else
                textView.append("코드에 의해 설정")
        }
        // 사용자가 터치 했을 때
        override fun onStartTrackingTouch(seekbar: SeekBar?) {
            when(seekBar?.id){
                R.id.seekBar -> textView2.text = "첫 번째 SeekBar 사용자 터치 시작"
                R.id.seekBar3 -> textView2.text = "두 번째 SeekBar 사용자 터치 시작"
            }
        }
        // 사용자가 터치 끝낼 때
        override fun onStopTrackingTouch(seekbar: SeekBar?) {
            when(seekBar?.id){
                R.id.seekBar -> textView2.text = "첫 번째 SeekBar 사용자 터치 종료"
                R.id.seekBar3 -> textView2.text = "두 번째 SeekBar 사용자 터치 종료"
            }
        }
    }
}