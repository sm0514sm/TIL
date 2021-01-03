package com.woobok.a3_12_progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "현재 값: ${progressBar4.progress}"
        }

        button2.setOnClickListener {
            progressBar4.progress = 150
        }

        button3.setOnClickListener {
            progressBar4.incrementProgressBy(10)
        }
        button4.setOnClickListener {
            progressBar4.incrementProgressBy(-10)
        }
    }
}