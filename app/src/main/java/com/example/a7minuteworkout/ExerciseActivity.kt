package com.example.a7minuteworkout

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit


class ExerciseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun startWorkout(view: View?) {
        //Start workout!
        findViewById<Button>(R.id.workoutButton).isEnabled = false

        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if(millisUntilFinished / 1000 == 0L) {
                    findViewById<Button>(R.id.workoutButton).text = "GO!"
                }
                else {
                    findViewById<Button>(R.id.workoutButton).text = (millisUntilFinished / 1000).toString()
                }

            }

            override fun onFinish() {
                findViewById<Button>(R.id.workoutButton).text = "GO!"
                workoutCountDown()
            }
        }.start()

    }

    fun workoutCountDown() {
        object : CountDownTimer(420000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                findViewById<Button>(R.id.workoutButton).text = getTimeStamp(millisUntilFinished)
                findViewById<ProgressBar>(R.id.workoutProgressBar).progress += ((1000.0/420000.0)*10000.0).toInt()
            }

            override fun onFinish() {
                findViewById<Button>(R.id.workoutButton).text = "workout done! \n retry?"
                findViewById<Button>(R.id.workoutButton).isEnabled = true
                findViewById<ProgressBar>(R.id.workoutProgressBar).progress = 0

            }
        }.start()
    }

    fun getTimeStamp(milliseconds : Long) : String {
        val minutes = ((milliseconds / (1000*60)) % 60);
        val seconds = (milliseconds / 1000) % 60 ;

        var minutesInString = if (minutes < 10) "0$minutes" else minutes.toString()
        var secondsInString = if (seconds < 10) "0$seconds" else seconds.toString()

        return "$minutesInString:$secondsInString"
    }

}