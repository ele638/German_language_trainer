package ru.ele638.germanlanguagetrainer.core.di

import org.koin.core.context.startKoin

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class KoinApp {
    fun initKoin()
}