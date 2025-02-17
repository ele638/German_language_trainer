package ru.ele638.germanlanguagetrainer.wordsList.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.ele638.germanlanguagetrainer.wordsList.domain.models.LanguageModel
import ru.ele638.germanlanguagetrainer.wordsList.domain.models.WordModel

interface WordsRepository {
    suspend fun loadWordsFromDB(): Flow<List<WordModel>>
}

class WordsRepositoryImpl(
    private val appDatabase: WordDataSource
) : WordsRepository {
    override suspend fun loadWordsFromDB(): Flow<List<WordModel>> = withContext(Dispatchers.IO) {
        appDatabase.getAll()
            .map { wordsList ->
                wordsList.map { word ->
                    WordModel(
                        word = word.name,
                        language = LanguageModel.GERMAN,
                        translations = emptyList()
                    )
                }
            }
    }
}