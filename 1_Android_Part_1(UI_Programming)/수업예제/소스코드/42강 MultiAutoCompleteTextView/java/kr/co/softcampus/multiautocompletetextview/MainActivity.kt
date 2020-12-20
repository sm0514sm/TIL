package kr.co.softcampus.multiautocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data = arrayOf(
            "abcd", "abca", "abcb", "abcc", "bbaa", "bbab", "bcab", "bdab"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data)

        // 구분자
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        multiAutoCompleteTextView.setAdapter(adapter1)

        button.setOnClickListener {
            // , 를 기준으로 문자열을 잘라낸다.
            val strArray = multiAutoCompleteTextView.text.split(",")

            textView.text = ""

            for(str1 in strArray){
                if(str1.trim() != ""){
                    textView.append("${str1.trim()}\n")
                }
            }
        }
        
        multiAutoCompleteTextView.setOnItemClickListener { parent, view, position, id -> 
            textView2.text = "${data[position]} 항목을 선택하였습니다"
        }
    }
}










