plugins {
    alias(libs.plugins.android.application)
}

android {
<<<<<<<< HEAD:formularzeOsobowe/app/build.gradle.kts
    namespace = "com.example.formularzeosobowe"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.formularzeosobowe"
========
    namespace = "com.example.skalowanie"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.skalowanie"
>>>>>>>> 253bc368b798855b0f91d425224f01dd461fd791:skalowanie/skalowanie/app/build.gradle.kts
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp.logging)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
