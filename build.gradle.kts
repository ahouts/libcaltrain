plugins {
    kotlin("jvm") version "1.3.61"
    id("com.github.ben-manes.versions") version "0.27.0"
}

group = "com.ahouts"
version = "0.1.0"

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