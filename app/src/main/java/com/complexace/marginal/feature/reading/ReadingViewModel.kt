package com.complexace.marginal.feature.reading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.complexace.marginal.core.model.Chapter
import com.complexace.marginal.core.model.Work
import com.complexace.marginal.repository.MarginalRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// Everything the reading UI can be in at any moment
sealed class ReadingState {
    object Loading : ReadingState()
    data class Success(val work: Work, val chapter: Chapter) : ReadingState()
    data class Error(val message: String) : ReadingState()
}

class ReadingViewModel(private val repository: MarginalRepository) : ViewModel() {

    private val _state = MutableStateFlow<ReadingState>(ReadingState.Loading)
    val state: StateFlow<ReadingState> = _state

    // Whether the chrome (top/bottom bars) is visible
    private val _chromeVisible = MutableStateFlow(false)
    val chromeVisible: StateFlow<Boolean> = _chromeVisible

    fun toggleChrome() {
        _chromeVisible.value = !_chromeVisible.value
    }

    fun load(workUrl: String, chapterUrl: String) {
        viewModelScope.launch {
            _state.value = ReadingState.Loading

            val workResult = repository.getWork(workUrl)
            val chapterResult = repository.getChapter(chapterUrl)

            if (workResult.isSuccess && chapterResult.isSuccess) {
                _state.value = ReadingState.Success(
                    work = workResult.getOrThrow(),
                    chapter = chapterResult.getOrThrow()
                )
            } else {
                _state.value = ReadingState.Error("Failed to load chapter")
            }
        }
    }
}