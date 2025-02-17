package ru.ele638.germanlanguagetrainer.ui.mainPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.delayEach
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import org.koin.compose.viewmodel.koinViewModel
import ru.ele638.germanlanguagetrainer.core.ui.MyApplicationTheme
import ru.ele638.germanlanguagetrainer.wordsList.domain.WordsInteractor
import ru.ele638.germanlanguagetrainer.wordsList.domain.models.LanguageModel
import ru.ele638.germanlanguagetrainer.wordsList.domain.models.WordModel
import ru.ele638.germanlanguagetrainer.wordsList.ui.MainPageViewModel

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    viewModel: MainPageViewModel = koinViewModel<MainPageViewModel>()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.wordsLoading) {
            CircularProgressIndicator()
        } else {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = viewModel::loadWords,
            ) {
                Text(
                    text = "Load words",
                )
            }
        }

        LazyColumn {
            items(state.wordList) { wordModel ->
                Card {
                    Column {
                        Text(
                            text = wordModel.word
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainPagePreview() {
    MyApplicationTheme {
        val mockInteractor = object : WordsInteractor {
            override suspend fun getWordList(): Flow<List<WordModel>> {
                return flowOf(
                    listOf(
                        WordModel(
                            word = "test1",
                            language = LanguageModel.GERMAN,
                            translations = emptyList()
                        )
                    )
                ).onEach {
                    delay(1000)
                }
            }
        }
        val viewModel = MainPageViewModel(mockInteractor)
        Surface {
            MainPage(
                modifier = Modifier.fillMaxSize(),
                viewModel = viewModel
            )
        }
    }
}