package kr.co.softcampus.scrollview

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

        button2.setOnClickListener {
            // 지정된 위치로 애니메이션 없이 이동
            // scroll1.scrollTo(0, 1000)
            // scroll2.scrollTo(1000, 0)
            
            // 지정된 위치로 애니메이션과 함께 이동
            // scroll1.smoothScrollTo(0, 1000)
            // scroll2.smoothScrollTo(1000, 0)
            
            // 현재 위치에서 지정된 만큼 애니메이션과 함께 이동
            scroll1.smoothScrollBy(0, 1000)
            scroll2.smoothScrollBy(1000, 0)
        }

        scroll1.setOnScrollChangeListener(listener1)

        scroll2.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            textView2.text = "X : $oldScrollX -> $scrollX"
        }
    }

    val listener1 = object : View.OnScrollChangeListener{
        override fun onScrollChange(v: View?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
            when(v?.id){
                R.id.scroll1 -> {
                    textView.text = "Y : $oldScrollY -> $scrollY"
                }
            }
        }
    }
}











