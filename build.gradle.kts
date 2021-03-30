import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
//	id("com.palantir.docker") version "0.22.1"
	kotlin("jvm") version "1.4.31"
	kotlin("plugin.spring") version "1.4.31"
}

group = "com.kongbarber.kongbackendapi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//buildscript {
//	repositories {
//		maven {
//			url = uri("https://plugins.gradle.org/m2/")
//		}
//	}
//	dependencies {
//		classpath("com.palantir.gradle.docker:gradle-docker:0.26.0")
//	}
//}
//
//apply(plugin = "com.palantir.docker")

//docker {
//	name 'hub.docker.com/diegolirio/my-app:version'
//	tags 'latest' // deprecated, use 'tag'
//	tag 'myRegistry', 'my.registry.com/username/my-app:version'
//	dockerfile file('Dockerfile')
//	files tasks.distTar.outputs, 'file1.txt', 'file2.txt'
//	buildArgs([BUILD_VERSION: 'version'])
//	labels(['key': 'value'])
//	pull true
//	noCache true
//}