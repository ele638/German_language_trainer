package ru.ele638.germanlanguagetrainer.core.db

import app.cash.sqldelight.db.SqlDriver
import ru.ele638.germanlanguagetrainer.AppDatabase

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): AppDatabase {
    val driver = driverFactory.createDriver()
    val database = AppDatabase(driver)

    // Do more work with the database (see below).

    return database
}