plugins {
    id("fabric-loom") version "1.14-SNAPSHOT"
    id("maven-publish")
}

version = project.property("mod_version")!!
group = project.property("maven_group")!!

repositories {
    // Add additional repositories here if needed
}

dependencies {
    val minecraft_version: String by project
    val loader_version: String by project
    val fabric_version: String by project

    minecraft("com.mojang:minecraft:$minecraft_version")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:$loader_version")
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabric_version")
}

loom {
    accessWidenerPath.set(file("src/main/resources/blocktuner.accesswidener"))
    mixin {
        defaultRefmapName.set("blocktuner-fabric-refmap.json")
    }
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand("version" to project.version)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(21)
}

java {
    withSourcesJar()
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.property("archivesBaseName")}" }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {

            artifact(tasks.named("remapJar")) {
                builtBy(tasks.named("remapJar"))
            }

            artifact(tasks.named("sourcesJar")) {
                builtBy(tasks.named("remapSourcesJar"))
            }
        }
    }
}
