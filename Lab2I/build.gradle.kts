import java.time.LocalDateTime

plugins {
    id("java")
    application
    id("com.gradleup.shadow") version "9.4.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

application{
    mainClass = "org.example.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.20.0")

    implementation("ch.qos.logback:logback-classic:1.5.32")
    implementation("org.slf4j:slf4j-api:2.0.17")

    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.shadowJar {
    manifest {
        attributes(Pair("Main-Class", "org.example.Main"))
    }
}

tasks.test {
    useJUnitPlatform()
}

abstract class PrintInfoTask : DefaultTask() {

    @TaskAction
    fun print() {
        println("======================================")
        println("Это моя первая пользовательская задача!")
        println("Проект: ${project.name}")
        println("Версия Gradle: ${project.gradle.gradleVersion}")
        println("======================================")
    }
}
tasks.register<PrintInfoTask>("printInfo") {
group = "Custom"
description = "Выводит информацию о проекте"
}

abstract class GenerateBuildPassportTask : DefaultTask() {

    @TaskAction
    fun generate() {
        val resourcesDir = project.layout.projectDirectory.dir("src/main/resources")
        val outputFile = resourcesDir.file("build-passport.properties").asFile

        resourcesDir.asFile.mkdirs()

        val username = System.getenv("USERNAME")
            ?: System.getenv("USER")
            ?: "unknown"

        outputFile.writeText(
            """
            user=$username
            os=${System.getProperty("os.name")}
            javaVersion=${System.getProperty("java.version")}
            buildTime=${'$'}{LocalDateTime.now()}
            message=Hello from custom Gradle task!
            """.trimIndent()
        )

        println("Build passport generated: ${outputFile.absolutePath}")
    }
}

tasks.register<GenerateBuildPassportTask>("generateBuildPassport") {
    group = "Custom"
    description = "Создает build-passport.properties с информацией о сборке"
}

tasks.named("processResources") {
    dependsOn(tasks.named("generateBuildPassport"))
}