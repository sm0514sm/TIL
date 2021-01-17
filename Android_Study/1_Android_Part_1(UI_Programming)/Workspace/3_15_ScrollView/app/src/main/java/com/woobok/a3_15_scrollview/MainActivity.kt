package com.woobok.a3_15_scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Y : ${scroll1.scrollY}"
            textView2.text = "X : ${scroll2.scrollX}"
        }
        
        button1.setOnClickListener {
//            scroll1.scrollTo(0, 1000)
//            scroll2.scrollTo(1000, 0)
//            scroll1.smoothScrollTo(0, 1000)
//            scroll2.smoothScrollTo(1000, 0)
            scroll1.smoothScrollBy(0, 100)
            scroll2.smoothScrollBy(100, 0)
        }

        scroll1.setOnScrollChangeListener(listener1)

        scroll2.setOnScrollChangeListener { view, scrollX, scrollY, oldScrollX, oldScrollY ->
            textView2.text = "X: $oldScrollX -> $scrollX"
        }
    }

    val listener1 = object: View.OnScrollChangeListener{
        override fun onScrollChange(v: View?, scrollX: Int, scollY: Int, oldScrollX: Int, oldScrollY: Int) {
            when(v?.id) {
                R.id.scroll1 -> textView.text = "Y: $oldScrollY -> $scollY"
            }
        }
    }
}