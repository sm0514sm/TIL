package com.woobok.a3_14_ratingbar

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
            textView.append("Rating 4 : ${ratingBar4.rating}\n")
        }

        button2.setOnClickListener {
            ratingBar.rating = 1.0f
            ratingBar2.rating = 2.0f
            ratingBar3.rating = 3.0f
            ratingBar4.rating = 4.0f
        }
        ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->  }

        ratingBar2.setOnRatingBarChangeListener(listener1)
        ratingBar3.setOnRatingBarChangeListener(listener1)

        ratingBar4.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            textView3.text = "Rating 4 : $rating\n"
            if (fromUser) textView3.append("사용자에 의해 설정\n")
            else textView3.append("코드에 의해 설정\n")
        }
    }

    val listener1 = RatingBar.OnRatingBarChangeListener { rb, rating, fromUser ->
        when (rb) {
            ratingBar2 -> {
                textView.text = "Rating 2 : $rating\n"
                if (fromUser) textView.append("사용자에 의해 설정\n")
                else textView.append("코드에 의해 설정\n")
            }
            ratingBar3 -> {
                textView2.text = "Rating 3 : $rating\n"
                if (fromUser) textView2.append("사용자에 의해 설정\n")
                else textView2.append("코드에 의해 설정\n")
            }
        }
    }
}