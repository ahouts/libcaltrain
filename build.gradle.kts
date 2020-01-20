import org.gradle.api.tasks.bundling.Jar
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    kotlin("jvm") version "1.3.61"
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.4"
    id("com.github.ben-manes.versions") version "0.27.0"
}

group = "com.ahouts"
version = "0.1.0-SNAPSHOT"
description = "library for parsing and utilizing public Caltrain data"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(group = "org.jsoup", name = "jsoup", version = "1.12.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testImplementation(kotlin("reflect"))

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    test {
        useJUnitPlatform()
    }
}

sourceSets["main"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDir("src/main/kotlin")
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

publishing {
    publications {
        create<MavenPublication>("lib") {
            from(components["java"])
            artifact(sourcesJar)
            groupId = "com.ahouts"
            artifactId = "libcaltrain"
            version = project.version.toString()
        }
    }
}

bintray {
    user = System.getenv("BINTRAY_USER")
    key = System.getenv("BINTRAY_KEY")
    setPublications("lib")
    with(pkg) {
        repo = "ahouts"
        name = "libcaltrain"
        userOrg = "ahouts"
        setLicenses("Apache-2.0")
        websiteUrl = "https://github.com/ahouts/libcaltrain"
        vcsUrl = "https://github.com/ahouts/libcaltrain.git"
        with(version) {
            name = project.version.toString()
            desc = "${project.description} ${project.version}"
            vcsTag = project.version.toString()
        }
    }
}
