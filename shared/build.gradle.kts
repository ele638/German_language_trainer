import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.sqldelight.coroutines)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(libs.lifecycle.viewmodel.compose)
            implementation(libs.kotlin.serialization)
            implementation(libs.ktor.core)
            implementation(libs.ktor.content.negotiation)
            implementation(libs.ktor.serialization.json)
            implementation(libs.ktor.logging)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
        }
        androidMain.dependencies {
            implementation(libs.sqldelight.android)
            implementation(libs.compose.ui.tooling)
            implementation(libs.ktor.android)
            implementation(libs.koin.android)
        }
        iosMain.dependencies {
            implementation(libs.sqldelight.native)
            implementation(libs.ktor.ios)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }

    sqldelight {
        databases {
            create("AppDatabase") {
                packageName.set("ru.ele638.germanlanguagetrainer")
            }
        }
    }
}

android {
    namespace = "ru.ele638.germanlanguagetrainer"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling.preview)
    }
}
