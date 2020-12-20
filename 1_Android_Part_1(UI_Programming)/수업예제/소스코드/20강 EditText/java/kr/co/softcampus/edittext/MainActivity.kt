package kr.co.softcampus.edittext

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            textView1.text = editText1.text

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(editText1.windowToken, 0)

            editText1.clearFocus()
        }

        editText1.addTextChangedListener(listener1)

        editText1.setOnEditorActionListener { v, actionId, event ->
            textView1.text = "엔터 버튼을 눌렀습니다"
            textView2.text = editText1.text
            false
        }
    }
    
    val listener1 = object : TextWatcher{
        // 문자열이 변경되기 전
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            textView1.text = "before : $s"
        }
        
        // 문자열 변경 작업이 완료되었을 때
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            textView2.text = "changed : $s"
        }
        // 변경된 문자열이 화면에 반영되었을 때
        override fun afterTextChanged(s: Editable?) {
            textView3.text = "after : $s"
        }
    }
}














