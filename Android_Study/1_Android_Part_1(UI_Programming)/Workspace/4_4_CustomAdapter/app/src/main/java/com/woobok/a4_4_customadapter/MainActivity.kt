package com.woobok.a4_4_customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list1.adapter = adapter1
    }

    val adapter1 = object: BaseAdapter(){
        // 항목의 개수를 반환
        override fun getCount(): Int {
            return data1.size
        }

        // listView 의 한 항목 가져오기
        // 10개 중에 화면에 3개밖에 안보이면 이 함수를 3번 반복함
        // 스크롤하면 보이는 만큼 함수 더 실행
        // 나왔던게 사라졌다 다시 생기면 convertView (ReadOnly임)
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            // 재사용 가능한 View 를 변수에 담기
            var rowView = convertView
            if (rowView == null){ // 나왔다 사라진게 없다면 새로 생성
                // layoutInflater.inflate: layout 으로부터 View 를 만들어 root 에 붙이겠다.
                rowView = layoutInflater.inflate(R.layout.row, null)
            }
            // ListView 의 항목 하나에 속한 것이기 때문에 아래 코드만 있다면 에러
            // rowTextView.text = data1[position]
            // 따라서 항목 뷰 내에 배치되어 있는 뷰들의 주소값을 가져옴
//            val text1 = rowView?.findViewById<TextView>(R.id.rowTextView)
//            val btn1 = rowView?.findViewById<TextView>(R.id.rowButton1)
//            val btn2 = rowView?.findViewById<TextView>(R.id.rowButton2)
//
//            text1?.text = data1[position]
//
//            btn1?.tag = position
//            btn2?.tag = position
//
//            btn1?.setOnClickListener{
//                textView.text = "${it.tag} 의 첫 번째 버튼을 눌렀당"
//            }
//            btn2?.setOnClickListener{
//                textView.text = "${it.tag} 의 두 번째 버튼을 눌렀당"
//            }
            rowView?.run{
                // rowView 내의 주소 값들도 가져오기 때문에 직접 id 가져오지 않아도 됨
                rowTextView?.text = data1[position]

                rowButton1?.tag = position
                rowButton2?.tag = position

                rowButton1?.setOnClickListener{
                    textView.text = "${it.tag} 의 첫 번째 버튼을 눌렀당!!"
                }
                rowButton2?.setOnClickListener{
                    textView.text = "${it.tag} 의 두 번째 버튼을 눌렀당!!"
                }
            }
            return rowView!!
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }
    }
}