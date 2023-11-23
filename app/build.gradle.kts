@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
//    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
//    alias(libs.plugins.google.services)
//    alias(libs.plugins.firebase.distribution)
//    alias(libs.plugins.firebase.crashlytics)
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
}

android {
    val appId: String by rootProject.extra
    val compileSdkVersion: Int by rootProject.extra
    val minSdkVersion: Int by rootProject.extra
    val targetSdkVersion: Int by rootProject.extra
    val appVersion: String by rootProject.extra
    val appVersionCode: Int by rootProject.extra

    namespace = appId

    defaultConfig {
        applicationId = appId
        minSdk = minSdkVersion
        targetSdk = targetSdkVersion
        compileSdk = compileSdkVersion
        versionName = appVersion
        multiDexEnabled = true
        versionCode = appVersionCode
//        versionNameSuffix = "$appVersionCode"
//
//        println("Version Code: $versionCode")
//        println("Version Name Suffix: $versionNameSuffix")

        buildConfigField("int", "MIN_SDK_VERSION", minSdk.toString())

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

//    signingConfigs {
//        getByName("debug") {
//            storeFile = file("${project.rootDir.absoluteFile}/app//key/myKey.jks")
//            storePassword = "key@2023"
//            keyAlias = "myKey"
//            keyPassword = "key@2023"
//        }
//        create("release") {
//            storeFile = file("${project.rootDir.absoluteFile}/app//key/myKey.jks")
//            storePassword = "key@2023"
//            keyAlias = "myKey"
//            keyPassword = "key@2023"
//        }
//    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
//            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
//            signingConfig = signingConfigs.getByName("release")
        }
    }

    androidResources {
        generateLocaleConfig = true
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

    lint {
        disable += "LongLogTag"
        warning += "MissingTranslation"
        warning += "ImpliedQuantity"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

val allFeatures = project
    .rootProject
    .subprojects
    .filter { it.path.startsWith(":feature:") }

val allCoreLibs = project
    .rootProject
    .subprojects
    .filter { it.path.startsWith(":core:") }

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
//    allFeatures.plus(allCoreLibs).forEach { implementation(project(it.path)) }
    allCoreLibs.forEach { implementation(project(it.path)) }

    // AndroidX & Google
    implementation(libs.core.ktx)
    implementation(libs.navigation.compose)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.coordinatorlayout)
    implementation(libs.androidx.biometric)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.preference.ktx)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.splash.screen)
    implementation(libs.androidx.work)
    implementation(libs.google.material)
//    implementation(platform(libs.firebase.bom))
//    implementation(libs.bundles.firebase)
//    implementation(libs.fackbook.ad)

    // Coroutines
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

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
    implementation(libs.lifecycle.runtime.compose)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.alibaba:fastjson:1.2.76")
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    implementation(libs.accompanist.placeholder)
//    implementation(libs.compose.webview)

    // Dependency Injection
    implementation(libs.javax.inject)
    implementation(libs.hilt.core)
    implementation(libs.hilt.android)
    implementation(libs.hilt.work)
    implementation(libs.hilt.navigation)
    kapt(libs.hilt.compiler)
    kapt(libs.hilt.android.compiler)

    // Bundles
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.navigation)

    // Other
    implementation(libs.zxing.android.embedded)
    implementation(libs.wireguard.android.tunnel)
    implementation(libs.compose.state.events)
    implementation(libs.logging.timber)

    testImplementation(libs.junit)
    testImplementation(libs.hilt.android.test)
    testImplementation(testlib.bundles.unit.test)
    testImplementation(testlib.truth.ext)
    testImplementation(testlib.test.core.ktx)
    testImplementation(libs.bundles.unit.test)
    testImplementation(platform(testlib.junit5.bom))
    testImplementation(testlib.bundles.junit5.api)
    testRuntimeOnly(testlib.junit.jupiter.engine)
    coreLibraryDesugaring(libs.desugarJdkLibs)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("-Xlint:unchecked")
    options.isDeprecation = true
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
}

/**
 * Gradle task for getting the app version name
 * Run ./gradlew -q printAppVersionName
 */
tasks.register("printAppVersionName") {
    doLast {
        println(android.defaultConfig.versionName)
    }
}