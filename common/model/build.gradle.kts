plugins {
    `java-library`
}

dependencies {
    val kotlinVersion = "1.3.72"

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8