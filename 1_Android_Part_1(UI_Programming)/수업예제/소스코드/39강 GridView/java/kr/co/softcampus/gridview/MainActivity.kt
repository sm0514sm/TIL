package kr.co.softcampus.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val data1 = arrayOf(
            "그리드1", "그리드2", "그리드3", "그리드4", "그리드5",
            "그리드6", "그리드7", "그리드8", "그리드9", "그리드10"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adaper1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)

        grid1.adapter = adaper1

        // grid1.setOnItemClickListener(listener1)
        
        grid1.setOnItemClickListener { parent, view, position, id -> 
            textView.text = "${data1[position]} 항목을 클릭하였습니다"
        }
    }
    
    val listener1 = object : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id){
                R.id.grid1 -> {
                    textView.text = "${data1[position]} 항목을 클릭하였습니다"
                }
            }
        }
    }
}










