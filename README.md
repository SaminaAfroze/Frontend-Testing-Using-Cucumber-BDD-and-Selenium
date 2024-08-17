# Frontend Testing with Cucumber, Gherkin, Java, and Selenium

## Introduction

This project is a frontend testing suite using Cucumber for BDD with Gherkin syntax, implemented in Java, and Selenium for browser automation.

## Prerequisites

- Java Development Kit (JDK) 11.0.21 (LTS)
- Maven
- ChromeDriver (or equivalent)
- IDE (IntelliJ IDEA, Eclipse, etc.)

## Project Structure

project-root/
├── src/
│ ├── main/
│ └── test/
│ ├── java/
│ │ └── com/
│ │ └── soc/
│ │ └── steps/
│ └── resources/
│ └── feature/
├── pom.xml
└── README.md


## Setup

### Clone the Repository

```sh
git clone <repository-url>
cd <repository-directory>

Install Dependencies
Copy code
mvn clean install
Configure WebDriver
Ensure the WebDriver (e.g., ChromeDriver) is installed and its path is set.

Writing Tests
Feature Files
Located in src/test/resources/feature, written in Gherkin syntax.

Step Definitions
Located in src/test/java/com/soc/steps, implementing Gherkin steps in Java.

Test Runners
Located in src/test/java/Runners, configuring and running Cucumber tests.

Running Tests
Use Maven:

sh
Copy code
mvn test
