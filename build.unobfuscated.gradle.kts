plugins {
    id("net.fabricmc.fabric-loom")
    // id("me.modmuss50.mod-publish-plugin") version "1.1.0"
}

version = "${property("mod.version")}+${sc.current.version}"
base.archivesName = property("mod.id") as String

val requiredJava = when {
    sc.current.parsed >= "26.1" -> JavaVersion.VERSION_25
    sc.current.parsed >= "1.20.5" -> JavaVersion.VERSION_21
    sc.current.parsed >= "1.18" -> JavaVersion.VERSION_17
    sc.current.parsed >= "1.17" -> JavaVersion.VERSION_16
    else -> JavaVersion.VERSION_1_8
}

repositories {
    fun strictMaven(url: String, alias: String, vararg groups: String) = exclusiveContent {
        forRepository { maven(url) { name = alias } }
        filter { groups.forEach(::includeGroup) }
    }

    strictMaven("https://www.cursemaven.com", "CurseForge", "curse.maven")
    strictMaven("https://api.modrinth.com/maven", "Modrinth", "maven.modrinth")
}

dependencies {
    fun fapi(vararg modules: String) {
        for (module in modules) {
            modImplementation(fabricApi.module(module, property("deps.fabric_api") as String))
        }
    }

    minecraft("com.mojang:minecraft:${sc.current.version}")
    implementation("net.fabricmc:fabric-loader:${property("deps.fabric_loader")}")
    implementation("net.fabricmc.fabric-api:fabric-api:${property("deps.fabric_api")}")

    fapi("fabric-lifecycle-events-v1", "fabric-resource-loader-v0", "fabric-content-registries-v0")
}

val accessWidener = when {
    sc.current.parsed >= "26.1" -> "blocktuner.unobfuscated.accesswidener"
    else -> "blocktuner.obfuscated.accesswidener"
}

loom {
    fabricModJsonPath = rootProject.file("src/main/resources/fabric.mod.json")
    accessWidenerPath = rootProject.file("src/main/resources/$accessWidener")

    decompilerOptions.named("vineflower") {
        options.put("mark-corresponding-synthetics", "1")
    }

    runConfigs.all {
        ideConfigGenerated(true)
        vmArgs("-Dmixin.debug.export=true")
        runDir = "../../run"
    }

    mixin {
        useLegacyMixinAp = true
    }
}

java {
    withSourcesJar()
    targetCompatibility = requiredJava
    sourceCompatibility = requiredJava
}

val fabricApiKey =
    if (sc.current.parsed <= "1.19.2") "fabric"
    else "fabric-api"

tasks {
    processResources {
        val props = mapOf(
            "id" to project.property("mod.id"),
            "name" to project.property("mod.name"),
            "version" to project.property("mod.version"),
            "minecraft" to project.property("mod.mc_dep"),
            "fabricLoader" to project.property("build.fabric_loader"),
            "fabricAPI" to project.property("build.fabric_api"),
            "fabricApiKey" to fabricApiKey,
            "accesswidener" to accessWidener
        )

        filesMatching("fabric.mod.json") { expand(props) }

        val mixinJava = "JAVA_${requiredJava.majorVersion}"
        val refmapName = "blocktuner-refmap.json"
        filesMatching("*.mixins.json") {
            expand(
                mapOf(
                    "java" to mixinJava,
                    "refmap" to refmapName
                )
            )
        }
    }

    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

    named<AbstractArchiveTask>("jar") {
        archiveFileName.set(
            "${project.property("mod.id")}-v${project.property("mod.version")}-mc${sc.current.version}.jar"
        )
    }

    named<AbstractArchiveTask>("sourcesJar") {
        archiveFileName.set(
            "${project.property("mod.id")}-v${project.property("mod.version")}-mc${sc.current.version}-sources.jar"
        )
    }

    register<Copy>("buildAndCollect") {
        group = "build"
        from(jar.map { it.archiveFile })
        into(rootProject.layout.buildDirectory.file("libs/${project.property("mod.version")}"))
        dependsOn("build")
    }

    register<Copy>("buildAndCollectRemapped") {
        group = "build"
        from(jar.map { it.archiveFile })
        into(rootProject.layout.buildDirectory.file("libs/${project.property("mod.version")}/remapped"))
        dependsOn("build")
    }

    register<Copy>("buildAndCollectSources") {
        group = "build"
        from(jar.map { it.archiveFile })
        into(rootProject.layout.buildDirectory.file("libs/${project.property("mod.version")}/sources"))
        dependsOn("build")
    }
}
