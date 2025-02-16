package ru.ele638.germanlanguagetrainer.ui.mainPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ele638.germanlanguagetrainer.domain.models.WordModel

class MainPageViewModel : ViewModel() {
    private val _state = MutableStateFlow(MainPageState())
    val state = _state.asStateFlow()

    fun loadWords() {
        viewModelScope.launch {
            _state.emit(MainPageState(wordsLoading = true))
            withContext(Dispatchers.IO) {
                delay(1000)
            }
            _state.emit(MainPageState(wordsLoading = false))
        }
    }
}

data class MainPageState(
    val wordList: List<WordModel> = emptyList(),
    val wordsLoading: Boolean = false
)