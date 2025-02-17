package ru.ele638.germanlanguagetrainer.wordsList.domain.models

data class WordModel(
    val word: String,
    val language: LanguageModel,
    val translations: List<WordModel>
)