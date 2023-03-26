plugins {
    java
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "de.jannes"
version = "1.0"

val groupID = project.group.toString()
val artifactID = project.name.toLowerCase()
val projektVersion = project.version.toString()
val projektName = project.name.toString()

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(files("./sas.jar"))
}

tasks {
    compileJava {
        options.release.set(17)
        options.encoding = "UTF-8"
    }

    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        archiveFileName.set("$projektName-shadowJar.jar")
    }
}

tasks.jar {
    manifest.attributes["Main-Class"] = "$groupID.$artifactID.ZahlRaten"
}