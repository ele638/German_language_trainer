package ru.ele638.germanlanguagetrainer.core.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import ru.ele638.germanlanguagetrainer.core.di.sharedModule

actual class KoinApp {
    actual fun initKoin() {
        startKoin(
            KoinApplication
                .init()
                .modules(sharedModule)
        )
    }
}