package com.example.bmiapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<SeekBar>(R.id.heightSeekBar).setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // TODO Auto-generated method stub
                var height : Double = progress.toDouble() / 100.0;
                findViewById<TextView>(R.id.textView4).text = height.toString() + "m";
            }
        })
        findViewById<SeekBar>(R.id.weightSeekBar).setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // TODO Auto-generated method stub
                findViewById<TextView>(R.id.textView5).text = progress.toString() + "kg";
            }
        })

    }




    fun calculateBMI(view: View?) {
        val intent = Intent(this@MainActivity, BMIActivity::class.java)

        val heightValue : Int = findViewById<SeekBar>(R.id.heightSeekBar).progress
        val weightValue : Int = findViewById<SeekBar>(R.id.weightSeekBar).progress

        intent.putExtra("height", heightValue)
        intent.putExtra("weight", weightValue)

        startActivity(intent)
    }
}


