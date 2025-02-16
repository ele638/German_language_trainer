package ru.ele638.germanlanguagetrainer.db

import app.cash.sqldelight.db.SqlDriver
import ru.ele638.germanlanguagetrainer.AppDatabase

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): AppDatabase {
    val driver = driverFactory.createDriver()
    val database = AppDatabase(driver)

    // Do more work with the database (see below).

    return database
}