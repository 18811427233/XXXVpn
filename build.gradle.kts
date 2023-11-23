// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
//    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
//    alias(libs.plugins.google.services) apply false
//    alias(libs.plugins.firebase.distribution) apply false
//    alias(libs.plugins.firebase.crashlytics) apply false
//    alias(libs.plugins.firebase.perf) apply false
}
true // Needed to make the Suppress annotation work for the plugins block

apply(from = "gradle/versions.gradle.kts")
//apply(from = "gradle/variables.gradle.kts")
//apply(from = "gradle/tools/util.gradle")

buildscript {
    dependencies {
        classpath(libs.hilt.gradle.plugin)
//        classpath(libs.google.services)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}