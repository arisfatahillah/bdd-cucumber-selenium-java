# Selenium Cucumber Java 
This repository contains an automated testing framework built with Selenium, Cucumber, Java, and Maven. The framework allows for easy creation and execution of feature files written in Gherkin syntax, providing a readable and maintainable way to define test scenarios.

## Features
- Integration of Selenium WebDriver for browser automation
- Utilization of Cucumber for behavior-driven development (BDD)
- Dependency management with Maven
- Easy setup and execution of test scenarios
- Readable and maintainable Gherkin syntax for defining test cases

## Prerequisites
Before running the tests, ensure that the following software is installed:
- Java Development Kit 11 (JDK)
- Maven
- Webdriver (Chromedriver based on your version from chrome browser)

## Setup
1. Clone the repository:
  ``` git@github.com:arisfatahillah/bdd-cucumber-selenium-java.git ```

2. Navigate to the project directory:
  ``` cd bdd-cucumber-selenium-java.git ```

3. Navigate to the project directory:
  ``` mvn clean install ```

## Writing Tests
1. Create a new feature file in the `src/test/java/resources/features` directory.
2. Write the test scenarios using Gherkin syntax
3. Implement the step definitions in Java under the `src/test/java/org/saucedemo/stepdef` package.

## Folder Structure
For your convenient please put the file based on the folder structure.

```
|src
|--main
│   ├── pages
│   │   └── BasePage.java
│   │   └── CheckoutPage.java
|--test
│   ├── stepdef
│   │   └── CheckoutStepDef.java
│   ├── runner
│   │   └── TestRunner.java
│   ├── features
│   │   └── Checkout.feature
|pom.xml

```

## License
MIT License