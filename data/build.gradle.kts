plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    id("com.google.dagger.hilt.android")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

android {
    namespace = "com.mastervpnproxy.android.data"
    val compileSdkVersion: Int by rootProject.extra
    compileSdk = compileSdkVersion

    defaultConfig {
        val minSdkVersion: Int by rootProject.extra
        minSdk = minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.wireguard.android.tunnel)

    implementation(libs.coroutines.core)
    implementation(libs.google.gson)
    implementation(libs.core.ktx)
    implementation(libs.hilt.work)
    implementation(libs.hilt.android)
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshi)
    implementation(libs.moshiKotlin)
    implementation(libs.okHttp)
    implementation(libs.okHttpLoggingInterceptor)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.preference.ktx)
    implementation(libs.logging.timber)
    implementation(libs.bundles.room)
    implementation(libs.androidx.security.crypto)
    implementation(libs.logging.interceptor)
    implementation(libs.google.ads)
    implementation(libs.google.ads.identifier)
    kapt(libs.room.compiler)
    kapt(libs.hilt.android.compiler)
    kapt(libs.hilt.compiler)

    testImplementation(testlib.bundles.unit.test)
    testImplementation(testlib.truth.ext)
    testImplementation(testlib.test.core.ktx)
    testImplementation(libs.bundles.unit.test)
    testImplementation(platform(testlib.junit5.bom))
    testImplementation(testlib.bundles.junit5.api)
    testRuntimeOnly(testlib.junit.jupiter.engine)

    androidTestImplementation(testlib.bundles.unit.test)
    androidTestImplementation(libs.bundles.unit.test)
    androidTestImplementation(testlib.junit.test.ktx)
    androidTestImplementation(testlib.runner)
}