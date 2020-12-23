package com.woobok.a3_3_edittext

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            textView1.text = editText1.text
            // 안드로이드에서 사용되는 기능 사용할때
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            // 키보드 창 닫히게 하기
            imm.hideSoftInputFromWindow(editText1.windowToken, 0)
            // 포커스 없애주기
            editText1.clearFocus()
        }
        editText1.addTextChangedListener(listener1)
        editText1.setOnEditorActionListener { v, actionId, event ->
            textView1.text = "엔터 버튼을 눌렀습니다"
            textView2.text = editText1.text
            // true 반환: 처리만 되고 키보드 유지
            // false 반환: 처리 후 키보드 내려감
            true
        }
    }

    val listener1 = object : TextWatcher{
        // 문자열 변경 전
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            textView1.text = "before : $s, $start, $count, $after"
        }
        // 문자열 변경 작업이 완료되었을 때
        override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            textView2.text = "changed : $s"
        }
        // 변경된 문자열이 화면에 반영되었을 때 (주로 많이 씀)
       override fun afterTextChanged(s: Editable?) {
            textView3.text = "after : $s"
        }

    }

}