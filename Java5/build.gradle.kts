plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Додайте MySQL JDBC-драйвер
    implementation("mysql:mysql-connector-java:8.0.33") // Оновіть до актуальної версії, якщо є

    // Залежності для тестування
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
