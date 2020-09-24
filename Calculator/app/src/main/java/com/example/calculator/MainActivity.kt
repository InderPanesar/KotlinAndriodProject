package com.example.calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var firstNumber : Double? = null
    var secondNumber : Double? = null
    var stringOperator : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        operatorButtonListeners()
        numberButtonListeners()
    }


    private fun operatorButtonListeners() {
        clearButton.setOnClickListener {
            answerTextView.text = ""
            firstNumber = null
            secondNumber = null
            stringOperator = null
        }
        multiplyButton.setOnClickListener {
            stringOperator = "Multiply"
            secondNumber = null
            operationControl()
            multiplyButton.setBackgroundColor(Color.GRAY)
        }
        addButton.setOnClickListener {
            stringOperator = "Addition"
            secondNumber = null
            operationControl()
            addButton.setBackgroundColor(Color.GRAY)
        }
        subtractButton.setOnClickListener {
            stringOperator = "Subtraction"
            secondNumber = null
            operationControl()
            subtractButton.setBackgroundColor(Color.GRAY)
        }
       divideButton.setOnClickListener {
            stringOperator = "Divide"
            secondNumber = null
            operationControl()
            divideButton.setBackgroundColor(Color.GRAY)
       }
        equalButton.setOnClickListener {
            if(firstNumber != null  && secondNumber != null)
            flowControl()
        }
    }

    private fun numberButtonListeners () {
        zeroButton.setOnClickListener {
            addNumberToDisplay(0)
        }
        oneButton.setOnClickListener {
            addNumberToDisplay(1)
        }
        twoButton.setOnClickListener {
            addNumberToDisplay(2)
        }
        threeButton.setOnClickListener {
            addNumberToDisplay(3)
        }
        fourButton.setOnClickListener {
            addNumberToDisplay(4)
        }
        fiveButton.setOnClickListener {
            addNumberToDisplay(5)
        }
        sixButton.setOnClickListener {
            addNumberToDisplay(6)
        }
        sevenButton.setOnClickListener {
            addNumberToDisplay(7)
        }
        eightButton.setOnClickListener {
            addNumberToDisplay(8)
        }
        nineButton.setOnClickListener {
            addNumberToDisplay(9)
        }
    }

    fun flowControl() {
        val number = answerTextView.text as String
        if(firstNumber == null) {
            firstNumber = number.toDoubleOrNull()
            answerTextView.text = ""
        }
        else if (secondNumber == null) {
            secondNumber = number.toDoubleOrNull()
            calculateAnswer()
        }
        else {
            if(firstNumber != null && secondNumber != null) {
                calculateAnswer()
            }
        }
    }

    fun operationControl() {
        if(firstNumber != null) {
            val number : String = answerTextView.text as String
            val num : Double? = number.toDoubleOrNull();
            if(num == firstNumber) {
                answerTextView.text = ""
            }
            else {
                flowControl()
            }
        }
        else {
            flowControl()
        }
    }

    fun addNumberToDisplay(number : Int) {
        var cs: String = answerTextView.text as String
        cs += number
        answerTextView.text = cs

        if(stringOperator != null ) {
            flowControl()
        }
        multiplyButton.setBackgroundColor(Color.LTGRAY)
        divideButton.setBackgroundColor(Color.LTGRAY)
        addButton.setBackgroundColor(Color.LTGRAY)
        subtractButton.setBackgroundColor(Color.LTGRAY)

    }

    fun calculateAnswer() {
        var value : Double? = null
        if(stringOperator.equals("Multiply")) {
            value = firstNumber!! * secondNumber!!
        }
        else if(stringOperator.equals("Divide")) {
            value = firstNumber!! / secondNumber!!
        }
        else if(stringOperator.equals("Addition")) {
            value = firstNumber!! + secondNumber!!
        }
        else if(stringOperator.equals("Subtraction")) {
            value = firstNumber!! - secondNumber!!
        }
        firstNumber = value
        answerTextView.text = value.toString()
    }



}