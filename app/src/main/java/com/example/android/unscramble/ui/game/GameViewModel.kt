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

    init {
        Log.d("Game Fragment","Game Fragment Terbuat")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("Game  Fragment", "Game Fragment Dihancurkan")
    }
}