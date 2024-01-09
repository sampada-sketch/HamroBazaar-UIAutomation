# UI Automation - HamroBazaar search using Selenium 4.15.0 with Java Focusing on Page Object Model pattern with page Factory

## Overview
This project is intended to use Selenium in Java focusing on Page Object Model (POM) using Page factory. It has been developed using Maven build, Eclipse IDE, JDK 11, and Selenium version 4.15.0. The project aims to automate UI of hamrobazzar web application ( Nepal's Online Marketplace) -https://hamrobazaar.com/

## Key Technologies Used
1. **Maven Build:** The project is built and managed using Apache Maven, ensuring a streamlined build process and dependency management.
2. **Eclipse IDE**: The development environment for this project is Eclipse, providing a robust and user-friendly platform for Java development.
3. **JDK 11:** The project is developed using Java Development Kit (JDK) version 11, taking advantage of the latest features and improvements in the Java language.
4. **Selenium 4.15.0**: Selenium is utilized for automated testing in this project. Version 4.15.0 provides the latest enhancements and fixes for efficient web automation.

## Software Requirements:
1. **Eclipse or IntelliJ**
2. **Jdk 8 or above** (I am using Jdk 11)
3. **Dependency of WebDriverManager:** [WebDriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager) (I am using version 5.6.3)
4. **Selenium dependency or jar file version**
5. **Chrome Browser driver is not required** as this project is implemented using `WebDriverManager()` method

## Project Setup:
1. Download [Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ](https://www.jetbrains.com/idea/download/).
2. Download Jdk 8.0 or above.
3. Clone and Import the project "HamroBazaar" from repository (Branch : **Master**)
4. Add dependency of WebDriverManager in `pom.xml`.
5. Add dependency of Selenium in `pom.xml`.
6. Alternatively, download Selenium jar and configure in build path by adding external JARs.
7. As the code is submitted as per POM design pattern, there are two page classes:
   - **Page Class:** Represents a web page, encapsulating its elements and functionalities. (`HamroPage.java`)
   - **Test Class:** Contains test methods that interact with the page elements using the methods provided by the corresponding Page Class. (`TestScriptHamro.java`)
8. Execute `TestScriptHamro.java` as Java Application.
9. CSV file is created in `C:/` drive inside the folder `CSV` (folder is self-created - no need to create one).
10. Data extracted after applying filters are also displayed in tabular format in the console of IDE.
