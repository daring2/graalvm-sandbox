plugins {
    id("java")
    id("org.graalvm.buildtools.native") version "0.10.1"
}

group = "io.github.daring2"

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.5")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

graalvmNative {
    binaries {
        named("main") {
//            mainClass.set("io.github.daring2.sadbox.HelloWorld")
            mainClass.set("io.github.daring2.sadbox.CheckSum")
        }
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Aproject=${project.group}/${project.name}")
}

tasks.test {
    useJUnitPlatform()
}
