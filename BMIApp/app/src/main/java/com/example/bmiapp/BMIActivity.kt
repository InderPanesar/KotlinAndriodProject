package com.example.bmiapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import kotlin.math.pow

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiresult)
        var height = intent.getIntExtra("height", 0)
        var weight = intent.getIntExtra("weight", 0)

        var bmi = weight.toDouble() / (height.toDouble()/100).pow(2.0)

        findViewById<TextView>(R.id.textView7).text = String.format("%.2f", bmi)

    }

    fun goBack(view: View?) {
        finish()
    }
}
