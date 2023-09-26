package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = 0
    val score : Int
        get() = _score
    private var _currentWordCount = 0
    val currentWordCount : Int
        get() = _currentWordCount
    private var _currenScrambleWord= "test"
    val currentScrambleWord: String
        get() = _currenScrambleWord
    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    init {
        Log.d("Game Fragment","Game ViewModel Terbuat")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Game  Fragment", "Game ViewModel Dihancurkan")
    }

    private  fun getNextWord(){
        currentWord = allWordsList.random()
    }
}