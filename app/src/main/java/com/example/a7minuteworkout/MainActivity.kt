package com.example.a7minuteworkout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startWorkout(view: View?) {
        //Start workout!
        val intent = Intent(this, ExerciseActivity::class.java)
        startActivityForResult(intent, 0)

    }
}