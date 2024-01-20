# Java Selenium Test Automation Project for Sauce Demo App

## Overview

This project is a test automation framework built for the [Sauce Demo App](https://www.saucedemo.com/). The framework is implemented using Java and incorporates Selenium WebDriver for browser automation, TestNG for test execution and management, Email Manager for handling email notifications, and ExtentReports for detailed test reporting. The architecture follows the Page Object Model (POM) design pattern, enhancing maintainability and reusability of code.

## Tools and Technologies Used

- **Java**: The primary programming language for writing test scripts and managing project structure.
- **Selenium WebDriver**: Employed for automating browser interactions and controlling web elements.
- **TestNG**: Used as the testing framework to organize and execute test cases efficiently.
- **Email Manager**: Integrated for managing email notifications related to test execution status.
- **ExtentReports**: Utilized for generating comprehensive and visually appealing HTML reports.

## Project Structure

The project follows a modular structure based on the Page Object Model, consisting of the following main components:

1. **Pages Package**: Contains classes representing individual pages of the Sauce Demo App. Each page class encapsulates the locators and methods related to that specific page.

2. **Tests Package**: Includes the actual test scripts written using TestNG. These tests interact with the Sauce Demo App using the methods provided by the corresponding page classes.

3. **Utils Package**: Contains utility classes for handling common functionalities such as WebDriver initialization, reading configuration parameters, and email notification management.

4. **Reports Folder**: Stores the ExtentReports-generated HTML reports for detailed analysis of test execution results.

## Test Execution Workflow

1. **Test Data Configuration**: Configure test data such as usernames, passwords, and other parameters in the configuration files or classes.

2. **Test Script Execution**: Execute test scripts using TestNG. Each test script interacts with the Sauce Demo App by utilizing the methods defined in the corresponding page classes.

3. **WebDriver Management**: WebDriver is initialized and managed through utility classes, ensuring a clean setup and teardown of the browser sessions.

4. **Email Notification**: Email Manager sends notifications regarding the test execution status, providing a quick overview of whether the tests passed or failed.

5. **Reporting**: ExtentReports generates detailed HTML reports, including information about test steps, assertions, and screenshots for failed tests.

## Benefits of Page Object Model

- **Maintainability**: Changes in the UI can be easily managed by updating the corresponding page class, minimizing the impact on test scripts.
  
- **Reusability**: Page classes encapsulate the logic for interacting with web elements, promoting code reuse across different test scripts.

- **Readability**: The separation of concerns in POM enhances code readability, making it easier for team members to understand and contribute to the project.

By combining Java, Selenium, TestNG, Email Manager, and ExtentReports within a Page Object Model architecture, this test automation project provides a robust and scalable framework for testing the Sauce Demo App.
