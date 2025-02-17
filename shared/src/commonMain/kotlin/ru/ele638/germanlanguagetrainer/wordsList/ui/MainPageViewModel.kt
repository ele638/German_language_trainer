package ru.ele638.germanlanguagetrainer.wordsList.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.ele638.germanlanguagetrainer.wordsList.domain.WordsInteractor
import ru.ele638.germanlanguagetrainer.wordsList.domain.models.WordModel

class MainPageViewModel(
    private val wordsInteractor: WordsInteractor
) : ViewModel() {
    private val _state = MutableStateFlow(MainPageState())
    val state = _state.asStateFlow()

    fun loadWords() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.emit(MainPageState(wordsLoading = true))
            wordsInteractor.getWordList()
                .collectLatest { wordsList ->
                    _state.emit(
                        MainPageState(
                            wordList = wordsList,
                            wordsLoading = false
                        )
                    )
                }

        }
    }
}

data class MainPageState(
    val wordList: List<WordModel> = emptyList(),
    val wordsLoading: Boolean = false
)