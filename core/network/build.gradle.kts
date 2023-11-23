plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "mega.vpn.android.core.network"

    val compileSdkVersion: Int by rootProject.extra
    compileSdk = compileSdkVersion

    defaultConfig {
        val minSdkVersion: Int by rootProject.extra
        minSdk = minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
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
        val javaVersion: JavaVersion by rootProject.extra
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    kotlin {
        val jdk: String by rootProject.extra
        jvmToolchain(jdk.toInt())
    }

    kotlinOptions {
        val jdk: String by rootProject.extra
        jvmTarget = jdk
        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }

    sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.coil.compose)
    implementation(libs.compose.state.events)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.navigation.compose)
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshi)

    // Dependency Injection
    implementation(libs.javax.inject)
    implementation(libs.hilt.core)
    implementation(libs.hilt.android)
    implementation(libs.hilt.work)
    implementation(libs.hilt.navigation)
    kapt(libs.hilt.compiler)
    kapt(libs.hilt.android.compiler)

    // Jetpack Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.ui.foundation)
    implementation(libs.material3)
    implementation(libs.coil.compose)
    implementation(libs.activity.compose)
    implementation(libs.constraintlayout.compose)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    implementation(libs.logging.timber)

}

tasks.withType<Test> {
    useJUnitPlatform()
}