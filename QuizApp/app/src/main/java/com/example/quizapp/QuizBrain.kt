package com.example.quizapp

import com.example.question.Question

class QuizBrain {

    var questionNumber = 0
    var answerChosen : Int? = null

    val questions : Array<Question> = arrayOf(
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 2, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "JOHN"), 1, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 3, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 4, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 1, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 2, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 1, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 3, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 4, R.drawable.flag),
            Question("What is this flag?", arrayOf("Bob", "John", "Fal", "WIN"), 4, R.drawable.flag),
            )

    val numberOfQuestion : Int = questions.size
}