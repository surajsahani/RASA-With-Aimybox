val componentsVersion: String by rootProject.extra
val aimyboxVersion: String by rootProject.extra

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

android {

    compileSdkVersion(29)

    defaultConfig {
        applicationId = "com.sumit.assistant"

        minSdkVersion(21)
        targetSdkVersion(29)

        versionName = componentsVersion
        versionCode = 1
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            //TODO configure pro guard
        }
    }

    lintOptions {
        isCheckAllWarnings = true
        isWarningsAsErrors = false
        isAbortOnError = true
    }
}

repositories {
    mavenLocal()
    google()
    jcenter()
    mavenCentral()
    maven("https://kotlin.bintray.com/kotlinx")
    maven("https://dl.bintray.com/aimybox/aimybox-android-sdk/")
    maven("https://dl.bintray.com/aimybox/aimybox-android-assistant/")
}

dependencies {

    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.3")

    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.3")

    // Aimybox
    implementation("com.justai.aimybox:components:$componentsVersion")
    implementation("com.justai.aimybox:core:$aimyboxVersion")
    implementation("com.justai.aimybox:google-platform-speechkit:$aimyboxVersion")
    implementation("com.justai.aimybox:rasa-api:$aimyboxVersion")

    // Lottie
    val lottieVersion = "3.4.0"
    implementation("com.airbnb.android:lottie:$lottieVersion")
}
