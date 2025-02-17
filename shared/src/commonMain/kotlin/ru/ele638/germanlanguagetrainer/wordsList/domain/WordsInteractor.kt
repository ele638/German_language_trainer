package ru.ele638.germanlanguagetrainer.wordsList.domain

import kotlinx.coroutines.flow.Flow
import ru.ele638.germanlanguagetrainer.wordsList.data.WordsRepository
import ru.ele638.germanlanguagetrainer.wordsList.domain.models.WordModel

interface WordsInteractor {
    suspend fun getWordList(): Flow<List<WordModel>>
}

class WordsInteractorImpl(
    private val wordsRepository: WordsRepository
): WordsInteractor {
    override suspend fun getWordList() : Flow<List<WordModel>> {
        return wordsRepository.loadWordsFromDB()
    }
}