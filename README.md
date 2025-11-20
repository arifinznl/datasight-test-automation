# Datasight Automation Project

Automasi pengujian untuk Web UI dan API menggunakan Java, Selenium, RestAssured, Cucumber, Gradle, dan Allure Report.  

---
## Installation Running
- **Java 17**
- **Gradle**
- **Cucumber**
- **Selenium WebDriver**
- **RestAssured**
- **Allure Report**
- **GitHub Actions (CI/CD)**
---

## Project Structure
```
.
├── api/                      # API automation (step definitions, pages, runners)
├── core/                     # DriverFactory & utilities
├── support/                  # Screenshot failure
├── web/                      # Web UI automation (step definitions, pages, runners)
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
└── README.md
```
## Web UI Tests
- Menggunakan Selenium + Chrome WebDriver (Headless).
- Driver diatur pada file `DriverFactory`.
- Seluruh scenario Web menggunakan tag: `@web`,
- Screenshot otomatis ketika gagal.

## API Tests
- Menggunakan RestAssured.
- Struktur terpisah dari Web.
- Semua scenario API menggunakan tag: `@api`,



## Quick Commands

### 1. Run All Tests
```sh
./gradlew test
```

### 2. Run Only Web
```sh
./gradlew webTest
```

### 3. Run Only API
```sh
./gradlew apiTest
```

### 4. Generate Allure report (local) 
```sh
allure serve build/allure-results
```



