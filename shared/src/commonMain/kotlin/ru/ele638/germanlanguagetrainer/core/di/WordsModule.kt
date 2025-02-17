package ru.ele638.germanlanguagetrainer.core.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.ele638.germanlanguagetrainer.wordsList.data.WordDataSource
import ru.ele638.germanlanguagetrainer.wordsList.data.WordsRepository
import ru.ele638.germanlanguagetrainer.wordsList.data.WordsRepositoryImpl
import ru.ele638.germanlanguagetrainer.wordsList.domain.WordsInteractor
import ru.ele638.germanlanguagetrainer.wordsList.domain.WordsInteractorImpl
import ru.ele638.germanlanguagetrainer.wordsList.ui.MainPageViewModel

val wordsModule = module {
    single<WordDataSource> { WordDataSource(get()) }
    single<WordsRepository> { WordsRepositoryImpl(get()) }
    single<WordsInteractor> { WordsInteractorImpl(get()) }
    viewModel<MainPageViewModel> { MainPageViewModel(get()) }
}