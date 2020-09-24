package com.example.question

class Question(val _question: String, val _answers: Array<String>, val _answer: Int, val _image: Int) {
    val question = _question
    val answers = _answers
    val answer = _answer
    val imageURL = _image
}