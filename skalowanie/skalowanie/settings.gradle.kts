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
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<<< HEAD:formularzeOsobowe/settings.gradle.kts
rootProject.name = "formularzeOsobowe"
========
rootProject.name = "Skalowanie"
>>>>>>>> 253bc368b798855b0f91d425224f01dd461fd791:skalowanie/skalowanie/settings.gradle.kts
include(":app")
 