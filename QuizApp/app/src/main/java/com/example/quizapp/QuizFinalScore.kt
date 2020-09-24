package com.example.quizapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score_screen.*

class QuizFinalScore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_screen)
        nameTextView.text = intent.getStringExtra("name")
        scoreTextView.text = intent.getStringExtra("score")
    }

    fun changeLayout(view: View) {
        //val intent = Intent(this@QuizFinalScore,MainActivity::class.java )
        //startActivity(intent)
        finish()

    }
}