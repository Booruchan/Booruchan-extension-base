import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.21"
    id("com.github.johnrengelman.shadow") version ("7.1.1")
    `java-library`
    `maven-publish`
}

group = "org.makentoshe.booruchan"
version = "0.3.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


publishing {
    publications {
        register<MavenPublication>("maven") {
            groupId = "om.github.makentoshe"
            artifactId = "booruchan-extension-base"
            version = "0.3.0"

            afterEvaluate {
                from(components["java"])
            }
        }
    }
}
