package ru.ele638.germanlanguagetrainer.ui.mainPage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.ele638.germanlanguagetrainer.ui.MyApplicationTheme

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    viewModel: MainPageViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()
    Column(modifier = modifier) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = viewModel::loadWords,
            enabled = !state.wordsLoading
        ) {
            Box(
                modifier = Modifier.fillMaxHeight()
            ) {
                if (state.wordsLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.fillMaxHeight()
                    )
                } else {
                    Text(
                        text = "Load words",
                    )
                }
            }

        }
    }
}

@Preview
@Composable
private fun MainPagePreview() {
    MyApplicationTheme {
        val viewModel = MainPageViewModel()
        Surface {
            MainPage(
                modifier = Modifier.fillMaxSize(),
                viewModel = viewModel
            )
        }
    }
}