plugins {
    kotlin("jvm") version "1.3.61"
}

group = "com.ahouts"
version = "0.1.0"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(group = "org.jsoup", name = "jsoup", version = "1.12.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testImplementation(kotlin("reflect"))

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()
    }
}