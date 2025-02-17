package ru.ele638.germanlanguagetrainer.core.di

import app.cash.sqldelight.db.SqlDriver
import org.koin.dsl.module
import ru.ele638.germanlanguagetrainer.AppDatabase
import ru.ele638.germanlanguagetrainer.core.db.DriverFactory
import ru.ele638.germanlanguagetrainer.core.db.createDatabase

actual val databaseModule = module {
    single<SqlDriver> { DriverFactory().createDriver() }
    single<AppDatabase> { createDatabase(get()) }
}