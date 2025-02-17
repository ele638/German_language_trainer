package ru.ele638.germanlanguagetrainer.core.di

import org.koin.dsl.module

val sharedModule = module {
    includes(databaseModule, wordsModule)
}