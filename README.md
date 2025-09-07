# RestAssured BDD Framework - Restful-Booker
This repo tests Create → Read → Update → Delete operations in https://restful-booker.herokuapp.com/ with Java, rest assured, cucumber framework.

Quick start:
1. Ensure Java 17 and Maven are installed.
2. From project root run:
   mvn clean test

Reports:
- Cucumber HTML: target/cucumber-reports.html
- Cucumber JSON: target/cucumber.json
- Allure: generate with `allure serve target/allure-results` (if Allure installed)

Quick notes to run:
Ensure Java 17 and Maven are installed.
Unzip (or use directly) and run from project root:
mvn clean test

Reports:
HTML: target/cucumber-reports.html
JSON: target/cucumber.json
Allure (optional): allure serve target/allure-results (if you have Allure installed)

