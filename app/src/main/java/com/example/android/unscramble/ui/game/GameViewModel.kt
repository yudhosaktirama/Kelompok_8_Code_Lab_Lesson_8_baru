package com.example.android.unscramble.ui.game

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



}