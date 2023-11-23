plugins {
    id("kotlin")
    id("com.android.lint")
    id("kotlin-kapt")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(libs.javax.inject)
    implementation(libs.coroutines.core)
//    implementation(libs.google.ads.identifier)
    implementation(libs.retrofitMoshi)
    implementation(libs.moshiKotlin)

    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.core)
}