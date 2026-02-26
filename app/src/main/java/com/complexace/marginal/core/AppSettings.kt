package com.complexace.marginal.core

import com.complexace.marginal.ui.theme.AppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

// Temporary — replace with Room-backed settings later
object AppSettings {
    private val _theme = MutableStateFlow(AppTheme.OLED)
    val theme: StateFlow<AppTheme> = _theme

    fun setTheme(theme: AppTheme) {
        _theme.value = theme
    }
}