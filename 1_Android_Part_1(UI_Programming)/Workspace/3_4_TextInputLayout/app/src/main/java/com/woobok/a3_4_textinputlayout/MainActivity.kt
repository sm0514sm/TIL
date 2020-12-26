package com.woobok.a3_4_textinputlayout

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
            textView1.text = textInputLayout1.editText?.text

            textInputLayout1.editText?.clearFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(textInputLayout1.editText?.windowToken, 0)
        }
        textInputLayout1.editText?.addTextChangedListener(listner1)
    }
    val listner1 = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(s: Editable?) {
            if(s != null) {
                if (s.length > ){
                    textInputLayout1.error = "10글자 이하로 입력해주세요"
                } else {
                    textInputLayout1.error = null
                }
            }
        }
    }
}