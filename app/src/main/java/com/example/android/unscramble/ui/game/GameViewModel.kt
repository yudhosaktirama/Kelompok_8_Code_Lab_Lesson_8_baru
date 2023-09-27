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
    private lateinit var _currenScrambleWord: String
    val currentScrambleWord: String
        get() = _currenScrambleWord
    private var wordList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    init {
        Log.d("Game Fragment","Game ViewModel Terbuat")
        getNextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Game  Fragment", "Game ViewModel Dihancurkan")
    }

    private  fun getNextWord(){
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordList.contains(currentWord)) {
            getNextWord()
        } else {
            _currenScrambleWord = String(tempWord)
            ++_currentWordCount
            wordList.add(currentWord)
        }
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

}