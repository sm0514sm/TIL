package kr.co.softcampus.textview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 뷰의 주소 값을 얻어온다.
        val text1 = findViewById<TextView>(R.id.text1)
        text1.text = "안녕하세요"
        text2.text = "반갑습니다"

        //text2.setBackgroundColor(Color.RED)
        //text2.setBackgroundColor(Color.rgb(100, 100, 200))
        text2.setBackgroundColor(Color.argb(100, 100, 100, 100))

        text2.setTextColor(Color.BLUE)

        text2.append("\n감사합니다")
    }
}









