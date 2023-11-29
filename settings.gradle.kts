pluginManagement {
    repositories {
        google()
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

rootProject.name = "AndroidEp1"
include(":app")
include(":app:androidintentexample")
include(":app:serviceexample")
include(":app:broadcastreceiverexample")
include(":app:fragmentexample")
