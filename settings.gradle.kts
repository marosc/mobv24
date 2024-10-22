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

val properties = java.util.Properties()
file("local.properties").inputStream().use { properties.load(it) }

// add to local.properties mapboxPrivateKey= ""
val mapboxPrivateKey: String? = properties.getProperty("mapboxPrivateKey")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Mapbox Maven repository
        maven {
            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
            // Do not change the username below. It should always be "mapbox" (not your username).
            credentials.username = "mapbox"
            // Use the secret token stored in gradle.properties as the password
            credentials.password = ""
            authentication.create<BasicAuthentication>("basic")
        }

    }
}

rootProject.name = "My Application"
include(":app")
