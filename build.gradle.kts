import java.util.*

plugins {
	java
	idea
	id("forge")
}

version = "${property("mc_version")}-${property("mod_version")}"
group = property("mod_group").toString()

minecraft {
	version = "${property("mc_version")}-${property("forge_version")}-${property("mc_version")}"
	runDir = "minecraft"
}

sourceSets.main.configure {
	java.srcDirs += project.file("src/main/java")
	output.setResourcesDir(project.file("$buildDir/classes/java/main/"))
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
	flatDir {
		dirs("deps")
	}
}

dependencies {
	compileOnly("org.projectlombok:lombok:1.18.+")
	annotationProcessor("org.projectlombok:lombok:1.18.+")

	file("$projectDir/deps").listFiles()?.forEach {
		val name = it.nameWithoutExtension
		if (name.endsWith("sources") || name.endsWith("javadoc")) return@forEach
		implementation(":$name")
	}
}

tasks {
	jar.configure {
		manifest {
			attributes(
				"Specification-Title" to project.property("mod_name"),
				"Specification-Vendor" to project.property("mod_authors"),
				"Specification-Version" to "1",
				"Implementation-Title" to project.name,
				"Implementation-Version" to project.version,
				"Implementation-Vendor" to project.property("mod_authors"),
				"Implementation-Timestamp" to Date().toInstant().toString()
			)
		}
	}

	register<Jar>("devJar") {
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
		manifest.attributes(jar.get().manifest.attributes)

		archiveClassifier.set("dev")
		from(sourceSets.main.get().output)
	}

	register<Jar>("sourcesJar") {
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
		manifest.attributes(jar.get().manifest.attributes)

		archiveClassifier.set("dev-sources")
		from(sourceSets.main.get().allSource)
		exclude("**/*.png", "**/*.obj", "**/*.mtl", "**/*.ogg", "**/*.ttf", "**/*.png.mcmeta")
	}

	withType<JavaCompile>().configureEach {
		options.encoding = "UTF-8"
	}

	withType<Jar>().configureEach {
		destinationDirectory.set(project.file("compiled"))
	}
}

artifacts {
	archives(tasks.named("devJar"))
	archives(tasks.named("sourcesJar"))
}
