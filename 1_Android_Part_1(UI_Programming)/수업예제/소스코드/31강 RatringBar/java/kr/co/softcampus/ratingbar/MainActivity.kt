package kr.co.softcampus.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            textView.text = "Rating 1 : ${ratingBar.rating}\n"
            textView.append("Rating 2 : ${ratingBar2.rating}\n")
            textView.append("Rating 3 : ${ratingBar3.rating}\n")
            textView.append("Rating 4 : ${ratingBar4.rating}")
        }

        button2.setOnClickListener {
            ratingBar.rating = 1.0f
            ratingBar2.rating = 2.0f
            ratingBar3.rating = 3.5f
            ratingBar4.rating = 4.0f
        }

        ratingBar2.setOnRatingBarChangeListener(listener1)
        ratingBar3.setOnRatingBarChangeListener(listener1)

        ratingBar4.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            textView3.text = "Rating 4 : ${rating}\n"
            
            if(fromUser == true){
                textView3.append("사용자에 의해 설정되었습니다")
            } else {
                textView3.append("코드를 통해 설정되었습니다")
            }
        }
    }

    var listener1 = object : RatingBar.OnRatingBarChangeListener{
        override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
            when(ratingBar?.id){
                R.id.ratingBar2 -> {
                    textView.text = "Rating 2 : ${rating}\n"
                    if(fromUser == true){
                        textView.append("사용자에 의해 설정되었습니다")
                    } else {
                        textView.append("코드를 통해 설정되었습니다")
                    }
                }
                R.id.ratingBar3 -> {
                    textView2.text = "Rating 3 : ${rating}\n"
                    if(fromUser == true){
                        textView2.append("사용자에 의해 설정되었습니다")
                    } else {
                        textView2.append("코드를 통해 설정되었습니다")
                    }
                }
            }
        }
    }
}












