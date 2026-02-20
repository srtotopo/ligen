plugins {
    id("java")
    id("org.graalvm.buildtools.native") version "0.10.1"
}

group = "io.github.srtotopo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

graalvmNative {
    binaries {
        named("main") {
            imageName.set("Ligen")
            mainClass.set("io.github.srtotopo.ligen.Main")
            fallback.set(false)
            buildArgs.add("--verbose")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}