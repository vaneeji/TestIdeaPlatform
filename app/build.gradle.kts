import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kapt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    alias(libs.plugins.hilt)
}

val appSignPassword: String by project

val pathStoreFile = "$rootDir/signing/TestIdeaPlatform.jks"

fun getLocalProperty(key: String, file: String = "local.properties"): String {
    val props = Properties()
    val localProps = rootProject.file(file)
    if (localProps.exists()) {
        localProps.inputStream().use {
            props.load(it)
        }
    }

    return props.getProperty(key) ?: ""
}

android {
    signingConfigs {
        val password by lazy { getLocalProperty("appSignPassword") }
        create("release") {
            storeFile = file(pathStoreFile)
            storePassword = appSignPassword.ifBlank { password }
            keyAlias = getLocalProperty(
                "keyAlias",
                "$rootDir/signing/keystore-release.properties"
            )
            keyPassword = appSignPassword.ifBlank { password }
        }
    }

    namespace = "com.example.testideaplatform"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.testideaplatform"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        room {
            schemaDirectory("$projectDir/schema")
        }
        setProperty("archivesBaseName", "ip-test-task")
    }

    splits {
        abi {
            isEnable = true
            reset()
            include("arm64-v8a", "x86_64")
            isUniversalApk = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs["release"]
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.room.ktx)
    implementation(libs.room.lib)
    ksp(libs.room.compiler)

    implementation(libs.hilt.lib)
    kapt(libs.hilt.compiler)
}