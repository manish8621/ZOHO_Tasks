package com.example.trivia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.trivia.databinding.FragmentGameBinding

class GameFragment:Fragment()
{
    private lateinit var questionAndAnswers: List<GameFragment.QuestionAndAnswer>
    private var correctAnswers = 0
    private var totalQuestions = 1
    private var questionsAnswered = 0
    private lateinit var binding: FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //init questions
        questionAndAnswers = getQuestionAndAnswers()
        totalQuestions = questionAndAnswers.size

        renderQuestion(questionAndAnswers[questionsAnswered+1])
        setOnClickListeners()
        setActionBarTitle("Trivia",questionsAnswered+1,totalQuestions)

    }

    private fun getQuestionAndAnswers(): List<QuestionAndAnswer> {
        var arr = mutableListOf<QuestionAndAnswer>()

        var question:String = "Which Linux command is used to display disk consumption of a specific directory?"
        arr.add(QuestionAndAnswer(question,choices = arrayOf("du","ds","dd","dds"), answer = "du"))

        question = " Which of the following abstract data types can be used to represent a many to many relation?"
        arr.add(QuestionAndAnswer(question,choices = arrayOf("Tree","Plex","Graph","Both (b) and (c)"), answer = "Graph"))

        question = "In networking terminology UTP means"
        arr.add(QuestionAndAnswer(question,choices = arrayOf("Unshielded Twisted pair ","Ubiquitious Teflon port","Uniformly Terminating port ","Unshielded T-connector port"), answer = "Unshielded T-connector port"))

        question = "The amount of uncertainty in a system of symbol is called?"
        arr.add(QuestionAndAnswer(question,choices = arrayOf("Bandwidth","Entropy","Loss","Quantum"), answer = "Entropy"))

        return arr
    }

    private fun renderQuestion(questionAndAnswer: QuestionAndAnswer) {
        binding.apply{
            questionTv.text = questionAndAnswers[questionsAnswered].question
            for (index in 0..choicesGroup.childCount) {
                (choicesGroup.getChildAt(index) as? RadioButton)?.text = questionAndAnswers[questionsAnswered].choices[index]
            }
        }
    }
    private fun setOnClickListeners() {
        //for radio buttons
        binding.apply {
            for (childIndex in 0..choicesGroup.childCount) {
                val choice: RadioButton? = (choicesGroup.getChildAt(childIndex) as? RadioButton)
                choice?.setOnClickListener {
                    questionAndAnswers[questionsAnswered].answerToCheck = choice.text as String
                    Log.v("my", questionAndAnswers[questionsAnswered].answerToCheck)
                }
            }
            //for submit button
            submitBtn.setOnClickListener {
                if (isValidAnswer()) {
                    //count correct answer
                    correctAnswers =
                        if (questionAndAnswers[questionsAnswered].isRightAnswerGiven) correctAnswers + 1 else correctAnswers

                    if (++questionsAnswered == totalQuestions) {
                        //check for win ,user should answer atleast half number of questions correctly
                        if (correctAnswers >= totalQuestions/2) {
                            findNavController().navigate(
                                GameFragmentDirections.actionGameFragmentToGameWinFragment(
                                    totalQuestions,
                                    correctAnswers
                                )
                            )
                        }
                        else
                            findNavController().navigate(
                                GameFragmentDirections.actionGameFragmentToGameOverFragment(
                                    totalQuestions,
                                    correctAnswers
                                )
                            )
                    }
                    else
                    {
                        renderQuestion(questionAndAnswers[questionsAnswered])
                        binding.choicesGroup.clearCheck()
                    }
                    setActionBarTitle("Trivia",questionsAnswered+1,totalQuestions)
                } else Toast.makeText(context, "Please select any answer", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }



    private fun isValidAnswer(): Boolean = binding.choicesGroup.checkedRadioButtonId != -1

    fun setActionBarTitle(_title:String,answered:Int,totalQuestions:Int){
        activity?.let {
            it.title = "$_title $answered / $totalQuestions"
        }
    }

    class QuestionAndAnswer(val question:String,val choices:Array<String>,val answer:String,var answerToCheck:String=""){
        val isRightAnswerGiven:Boolean
        get() = answer == answerToCheck
    }
}