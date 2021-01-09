package com.woobok.a4_7_viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewPager 를 통해 보여줄 View 담을 리스트
        val viewList = ArrayList<View>()
        val view1 = layoutInflater.inflate(R.layout.view1, null)
        val view2 = layoutInflater.inflate(R.layout.view2, null)
        val view3 = layoutInflater.inflate(R.layout.view3, null)
        val view4 = layoutInflater.inflate(R.layout.view1, null)
        val view5 = layoutInflater.inflate(R.layout.view2, null)
        val view6 = layoutInflater.inflate(R.layout.view3, null)

        viewList.add(view1)
        viewList.add(view2)
        viewList.add(view3)
        viewList.add(view4)
        viewList.add(view5)
        viewList.add(view6)

        val adapter = object: PagerAdapter() {
            // ViewPager 가 보여줄 View 개수
            override fun getCount(): Int {
                return viewList.size
            }

            // ViewPager 가 반환할 View
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                pager1.addView(viewList[position])
                return viewList[position]
            }

            // instantiateItem 이 반환한 객체를 화면으로 사용할 것인가 검사하는 메서드 (거의 고정)
            override fun isViewFromObject(view: View, obj: Any): Boolean {
                return view == obj
            }

            // 사라지는 View 객체를 없애는 메서드
            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                pager1.removeView(obj as View)
            }
        }

        pager1.adapter = adapter

        val listener1 = object: ViewPager.OnPageChangeListener {
            // 페이지의 스크롤이 끝났을 때 호출되는 메서드
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                textView.text = "$position 번째 View 가 완전히 나타남!"
            }
            // 페이지를 선택했을 때 호출되는 메서드
            override fun onPageSelected(position: Int) {
                textView2.text = "$position 번째 View 가 선택?! (넘어가는 중)"
            }

            // 페이지의 스크롤 상태가 변경되었을 때 호출되는 메서드
            override fun onPageScrollStateChanged(state: Int) {
                textView3.text = "$state 상태 (0: 정지,  1: 터치 중,  2: 터치 종료)"
            }
        }
        pager1.addOnPageChangeListener(listener1)
    }
}