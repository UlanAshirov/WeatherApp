pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("config") {
            from(files("gradle/config.versions.toml"))
        }
        create("options") {
            from(files("gradle/options.versions.toml"))
        }
    }
}
rootProject.name = "WeatherApp"
include(":app", ":core", ":common")
include(":features:main", ":features:main:data", ":features:main:domain")
