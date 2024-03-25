plugins {
    id("java")
    id("org.graalvm.buildtools.native") version "0.10.1"
}

group = "io.github.daring2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

graalvmNative {
    binaries {
        named("main") {
            mainClass.set("HelloWorld")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
