package com.example.hashtagselecter

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_go.setOnClickListener() {
            val text = et_text.text.toString()
            initView(text)
        }
    }

    fun initView(text: String) {

        val words = text.split(" ".toRegex())

        var sum = 0
        for (word in words) {
            if (word[0] == '#') {
                val wordtoSpan: Spannable = SpannableString(word)
                wordtoSpan.setSpan(ForegroundColorSpan(Color.BLUE), 0, word.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                sum++
                tv_show.append(wordtoSpan)
                if (sum != words.size){
                    tv_show.append(" ")
                }
            }else {
                sum++
                tv_show.append(word)
                if (sum != words.size) {
                    tv_show.append(" ")
                }
            }
        }
    }
}
