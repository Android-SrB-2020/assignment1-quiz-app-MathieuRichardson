package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.asn1_quizapp.Question

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    private var questionIndex = 0

    private lateinit var questionView : TextView
    private lateinit var  nextButton : Button
    private lateinit var  prevButton : Button
    private lateinit var  trueButton : Button
    private lateinit var  falseButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        questionView = findViewById(R.id.QuestionView)
        nextButton = findViewById(R.id.btnNext)
        prevButton = findViewById(R.id.btnPrev)
        trueButton = findViewById(R.id.btnTrue)
        falseButton = findViewById(R.id.btnFalse)

        displayQuestion()

        nextButton.setOnClickListener{
            questionIndex = (questionIndex + 1) % questionBank.size
            displayQuestion()
        }

        prevButton.setOnClickListener{
            if(questionIndex == 0){
                questionIndex = questionBank.size -1
            }
            else{
                questionIndex-=1
            }
            displayQuestion()
        }

        trueButton.setOnClickListener{
            if(questionBank[questionIndex].anwser){
                Toast.makeText(applicationContext,"Right Answer!", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext,"Wrong Answer!",Toast.LENGTH_LONG).show()
            }
        }

        falseButton.setOnClickListener{
            if(!questionBank[questionIndex].anwser){
                Toast.makeText(applicationContext,"Right Answer!",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext,"Wrong Answer!",Toast.LENGTH_LONG).show()
            }
        }
    }

    public fun displayQuestion(){
        questionView.setText(questionBank[questionIndex].TextResId)
    }
}
