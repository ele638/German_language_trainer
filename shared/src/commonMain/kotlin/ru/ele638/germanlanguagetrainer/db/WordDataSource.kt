package ru.ele638.germanlanguagetrainer.db

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import ru.ele638.germanlanguagetrainer.AppDatabase

class WordDataSource(private val db: AppDatabase) {
    private val queries = db.wordEntityQueries

    fun insert(id: Long? = null, name: String) {
        queries.insert(id = id, name = name)
    }

    // If you've added the coroutines extensions you'll be able to use asFlow()
    fun getAll() = queries.getAll().asFlow().mapToList(Dispatchers.IO)

    fun update(id: Long, name: String) {
        queries.updateName(id = id, name = name)
    }

    fun delete(id: Long) {
        queries.delete(id = id)
    }
}