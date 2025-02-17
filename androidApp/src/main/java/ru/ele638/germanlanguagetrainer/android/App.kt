package ru.ele638.germanlanguagetrainer.android

import android.app.Application
import ru.ele638.germanlanguagetrainer.core.di.KoinApp

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinApp(this).initKoin()
    }
}