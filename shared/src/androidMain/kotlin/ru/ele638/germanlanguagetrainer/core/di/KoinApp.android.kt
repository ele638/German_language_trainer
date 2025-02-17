package ru.ele638.germanlanguagetrainer.core.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import ru.ele638.germanlanguagetrainer.core.di.sharedModule

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinApp(private val context: Context) {
    actual fun initKoin() {
        startKoin(
            KoinApplication.init()
                .androidLogger()
                .androidContext(context)
                .modules(sharedModule)
        )
    }

}