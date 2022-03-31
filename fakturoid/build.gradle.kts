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
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

	implementation("com.konghq:unirest-java:3.13.6")
	implementation("com.konghq:unirest-objectmapper-jackson:3.13.6")

	implementation(
		"org.jetbrains.kotlin:kotlin-stdlib:1.6.10"
	)

	testImplementation("junit:junit:4.13.2")
	testImplementation("org.junit.vintage:junit-vintage-engine:5.8.2")
	testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
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
