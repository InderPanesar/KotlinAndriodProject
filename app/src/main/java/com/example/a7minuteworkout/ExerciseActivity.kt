package com.example.a7minuteworkout

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class ExerciseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val exercise_action_toolbar = findViewById<Toolbar>(R.id.exercise_action_toolbar)

        setActionBar(exercise_action_toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        exercise_action_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

}