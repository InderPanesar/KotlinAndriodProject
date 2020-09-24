package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionsActivity : AppCompatActivity() {

    var username : String? = null
    var score : Int = 0
    var qb : QuizBrain = QuizBrain()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        username = intent.getStringExtra("name")
        uiUpdate()
        buttonReset()

        answer1.setOnClickListener {
            buttonReset()
            qb.answerChosen = 1
            answer1.setBackgroundColor(Color.LTGRAY)
        }
        answer2.setOnClickListener {
            buttonReset()
            qb.answerChosen = 2
            answer2.setBackgroundColor(Color.LTGRAY)
        }
        answer3.setOnClickListener {
            buttonReset()
            qb.answerChosen = 3
            answer3.setBackgroundColor(Color.LTGRAY)
        }
        answer4.setOnClickListener {
            buttonReset()
            qb.answerChosen = 4
            answer4.setBackgroundColor(Color.LTGRAY)
        }
        submitButton.setOnClickListener {
            if(submitButton.text == "Go to next question!") {
                nextQuestion()
                answer1.isEnabled = true
                answer2.isEnabled = true
                answer3.isEnabled = true
                answer4.isEnabled = true
            }
            else {
                if(qb.answerChosen != null) {
                    answer1.isEnabled = false
                    answer2.isEnabled = false
                    answer3.isEnabled = false
                    answer4.isEnabled = false
                    checkAnswer()
                }
            }
        }
    }

    fun checkAnswer() {
        val answerChosen : Int = qb.answerChosen!!
        val answer = qb.questions[qb.questionNumber].answer
        if(answerChosen == answer) {
            score++
            buttonReset()
            setButton(Color.GREEN, answerChosen)
        }
        else {
            buttonReset()
            setButton(Color.GREEN, answer)
            setButton(Color.RED, answerChosen)
        }
        submitButton.text = "Go to next question!"

    }

    fun nextQuestion() {
        qb.questionNumber++;
        buttonReset()
        uiUpdate()
        submitButton.text = "SUBMIT"
        qb.answerChosen = null
    }


    fun setButton(color: Int, buttonNumber : Int) {
        if(buttonNumber == 1) {
            answer1.setBackgroundColor(color)
        }
        else if(buttonNumber == 2) {
            answer2.setBackgroundColor(color)
        }
        else if(buttonNumber == 3) {
            answer3.setBackgroundColor(color)
        }
        else if(buttonNumber == 4) {
            answer4.setBackgroundColor(color)
        }
    }

    fun buttonReset() {
        answer1.setBackgroundColor(Color.WHITE)
        answer2.setBackgroundColor(Color.WHITE)
        answer3.setBackgroundColor(Color.WHITE)
        answer4.setBackgroundColor(Color.WHITE)
    }


    fun uiUpdate() {
        if(qb.questionNumber == qb.numberOfQuestion) {
            qb.questionNumber = 0
            changeLayout()
        }
        answer1.text = qb.questions[qb.questionNumber].answers[0]
        answer2.text = qb.questions[qb.questionNumber].answers[1]
        answer3.text = qb.questions[qb.questionNumber].answers[2]
        answer4.text = qb.questions[qb.questionNumber].answers[3]
        questionText.text = qb.questions[qb.questionNumber].question
        imageQuestion.background = resources.getDrawable(qb.questions[qb.questionNumber].imageURL)
        determinateBar.progress = (((qb.questionNumber+1).toFloat()/qb.numberOfQuestion.toFloat())*100).toInt()
        answeredText.text = (qb.questionNumber+1).toString() + "/" + qb.numberOfQuestion.toString()
    }

    fun changeLayout() {
        val intent = Intent(this@QuizQuestionsActivity,QuizFinalScore::class.java )
        intent.putExtra("name", username)
        intent.putExtra("score", score.toString()+"/"+qb.numberOfQuestion)
        startActivity(intent)
    }

}