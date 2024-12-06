pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }

        mavenCentral()
        maven("https://jitpack.io")

        maven("https://github.com/jitsi/jitsi-maven-repository/raw/master/releases")
        maven("https://maven.google.com")
        gradlePluginPortal()

        maven("https://kotlin.bintray.com/kotlinx")
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "kotlinx-serialization" -> {
                    useModule("org.jetbrains.kotlinx:kotlinx-gradle-serialization-plugin:${requested.version}")
                }
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")

        maven("https://github.com/jitsi/jitsi-maven-repository/raw/master/releases")
    }
}

rootProject.name = "BipTestAssignment"
include(":app")
 