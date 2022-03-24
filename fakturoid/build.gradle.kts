import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.10"
}

group = "com.goforboom"
version = "0.0.1"

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("com.konghq:unirest-java:3.11.09")

	implementation(
		kotlin("stdlib")
	)

	testImplementation("junit:junit:4.12")
	testImplementation("org.junit.vintage:junit-vintage-engine:5.3.1")
}

tasks.withType<Test> {
	useJUnitPlatform()

	failFast = true // End after first failed test

	outputs.upToDateWhen { false }
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf(
			"-Xjsr305=strict",
			"-Xallow-result-return-type"
		)
		jvmTarget = "11"
	}
}
