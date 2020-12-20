package kr.co.softcampus.customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list1.adapter = adapter1
    }

    val adapter1 = object : BaseAdapter(){
        // 항목의 개수를 반환한다.
        override fun getCount(): Int {
            return data1.size
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        // 항목 하나를 구성하기 위해 호출되는 메서드
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            // 재사용 가능한 View를 변수에 담는다.
            var rowView = convertView

            if(rowView == null){
                rowView = layoutInflater.inflate(R.layout.row, null)
            }

            // 항목 뷰에 내부에 배치되어 있는 뷰들의 주소값을 가져온다.
//            val text1 = rowView?.findViewById<TextView>(R.id.rowTextView)
//            val btn1 = rowView?.findViewById<Button>(R.id.rowButton1)
//            val btn2 = rowView?.findViewById<Button>(R.id.rowButton2)
//
//            text1?.text = data1[position]
//
//            btn1?.tag = position
//            btn2?.tag = position
//
//            btn1?.setOnClickListener {
//                textView.text = "첫 번째 버튼을 눌렀습니다 : ${it.tag}"
//            }
//
//            btn2?.setOnClickListener {
//                textView.text = "두 번째 버튼을 눌렀습니다 : ${it.tag}"
//            }
            rowView?.run{
                rowTextView.text = data1[position]

                rowButton1.tag = position
                rowButton2.tag = position

                rowButton1.setOnClickListener {
                    textView.text = "첫 번째 버튼을 눌렀습니다 : ${it.tag}"
                }

                rowButton2.setOnClickListener {
                    textView.text = "두 번째 버튼을 눌렀습니다 : ${it.tag}"
                }
            }


            return rowView!!
        }
    }
}














