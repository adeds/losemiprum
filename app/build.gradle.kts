plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.0"

    defaultConfig {
        applicationId = "id.adeds.losemiprum"
        minSdkVersion(19)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // For Kotlin projects
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    dynamicFeatures = mutableSetOf(":feature:home")
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
}

dependencies {
    //version
    val kotlinVersion = "1.3.72"
    val ktxVersion = "1.3.0"
    val appCompatVersion = "1.1.0"
    val constraintLayoutVersion = "1.1.3"

    val rainbowCakeVersion = "1.0.0"
    val coroutinesVersion = "1.3.7"
    val daggerVersion = "2.15"
    val autoserviceVersion = "1.0-rc7"

    //module
    api(project(":common:core"))

    //base
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    api("androidx.core:core-ktx:$ktxVersion")
    api("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")

    //rainbowcake
    api("co.zsmb:rainbow-cake-core:$rainbowCakeVersion")
    api("co.zsmb:rainbow-cake-navigation:$rainbowCakeVersion")
    api("co.zsmb:rainbow-cake-dagger:$rainbowCakeVersion")
    implementation("co.zsmb:rainbow-cake-timber:$rainbowCakeVersion")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    kapt("com.google.dagger:dagger-android-processor:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")

    api("com.google.auto.service:auto-service-annotations:$autoserviceVersion")
    kapt("com.google.auto.service:auto-service:$autoserviceVersion")
}
