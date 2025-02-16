package ru.ele638.germanlanguagetrainer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform