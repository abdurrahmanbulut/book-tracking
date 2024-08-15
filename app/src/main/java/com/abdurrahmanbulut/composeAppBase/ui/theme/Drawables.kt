package com.abdurrahmanbulut.composeAppBase.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.abdurrahmanbulut.composeAppBase.R

var drawables by mutableStateOf(DrawablesLight())

open class Drawables {
    open val example: Int = 0
    open val back: Int = 0
}

class DrawablesLight : Drawables() {
    override val back: Int =  R.drawable.back
}
