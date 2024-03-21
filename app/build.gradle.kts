plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jersson.diaz.money"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jersson.diaz.money"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val composeBom = platform(libs.compose.boom)
    implementation(composeBom)
    implementation(libs.bundles.app.implements)
    kapt(libs.bundles.kapt)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.bundles.app.androidTest)
    testImplementation(libs.bundles.test)
    debugImplementation(libs.bundles.app.debud.implements)
    implementation(project(":domain"))
    implementation(project(":data"))
}