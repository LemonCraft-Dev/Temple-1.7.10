pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.minecraftforge.net/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "forge") {
                useModule("com.anatawa12.forge:ForgeGradle:1.2-1.1.+")
            }
        }
    }
}

rootProject.name = "Minecraft 1.7.10"
