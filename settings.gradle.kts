@file:Suppress("UnstableApiUsage")

rootProject.name = "XXXVpn"

include(":app")
include(":data")
include(":domain")
include(":core:ui")
include(":core:network")
include(":feature:empty")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }

    versionCatalogs {
        for (file in fileTree("./gradle/catalogs").matching { include("**/*.toml") }) {
            val name = file.name.split(".")[0]
            create(name) {
                from(files(file))
            }
        }
    }
}