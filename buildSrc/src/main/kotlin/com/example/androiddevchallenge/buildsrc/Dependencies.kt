package com.example.androiddevchallenge.buildsrc

object Libs{
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.3"
    object Accompanist {
        private const val version = "0.13.0"
        const val coil = "com.google.accompanist:accompanist-coil:$version"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val coilImage = "io.coil-kt:coil-compose:1.4.0"
    }

    object Google{
        const val material = "com.google.android.material:material:1.3.0"
    }

    object Kotlin{
        private const val version = "1.5.21"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Dagger {
        private const val daggerHilt = "2.38.1"
        private const val daggerHiltAndroid = "1.0.0"
        const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${daggerHilt}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:$daggerHiltAndroid"
        const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$daggerHiltAndroid"
        const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:$daggerHiltAndroid"
        const val hiltAndroid = "com.google.dagger:hilt-android:$daggerHilt"
    }

    object AndroidX{
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"

        object Compose{
            private const val compose_version = "1.0.1"
            const val ui = "androidx.compose.ui:ui:$compose_version"
            const val material = "androidx.compose.material:material:$compose_version"
            const val material_extended = "androidx.compose.material:material-icons-extended:$compose_version"
            const val ui_tooling = "androidx.compose.ui:ui-tooling:$compose_version"
            const val navigation = "androidx.navigation:navigation-compose:2.4.0-alpha10"
            const val paging = "androidx.paging:paging-compose:1.0.0-alpha14"
            const val jUnit = "androidx.compose.ui:ui-test-junit4:$compose_version"
            const val liveData = "androidx.compose.runtime:runtime-livedata:$compose_version"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-rc01"

        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha03"
        }

        object Test{
            const val jUnit = "androidx.test.ext:junit:1.1.2"
        }
    }

    object Test{
        const val jUnit = "junit:junit:4.13.2"
    }
}