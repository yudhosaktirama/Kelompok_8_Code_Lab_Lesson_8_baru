package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = MutableLiveData<Int>()
    val score : LiveData<Int>
        get() = _score
    private var _currentWordCount = MutableLiveData<Int>()
    val currentWordCount : LiveData<Int>
        get() = _currentWordCount
    private var _currenScrambleWord = MutableLiveData<String>()
    val currentScrambleWord: LiveData<String>
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
            _currenScrambleWord.value = String(tempWord)
            _currentWordCount.value = (_currentWordCount).value?.inc()
            wordList.add(currentWord)
        }
    }

    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        wordList.clear()
        getNextWord()
    }

    private fun increaseScore() {
        _score.value = _score.value?.plus(SCORE_INCREASE)
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    fun nextWord(): Boolean {
        return if (currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

}