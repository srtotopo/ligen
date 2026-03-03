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
    implementation("info.picocli:picocli:4.7.7")
    annotationProcessor("info.picocli:picocli-codegen:4.7.7")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

graalvmNative {
    binaries {
        named("main") {
            imageName.set("ligen")
            mainClass.set("io.github.srtotopo.ligen.Main")
            fallback.set(false)
            buildArgs.add("--verbose")
            buildArgs.add("--enable-url-protocols=jar")
            buildArgs.add("-H:IncludeResources=templates/.*\\.txt$")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}