package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    fun changeLayout(view: View) {
        val intent = Intent(this@MainActivity,QuizQuestionsActivity::class.java )
        val name : String = nameEditText.text.toString()
        intent.putExtra("name", name)
        startActivity(intent)
    }



}