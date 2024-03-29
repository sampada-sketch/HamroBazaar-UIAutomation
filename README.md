# UI Automation - HamroBazaar search using Selenium 4.15.0 with Java Focusing on Page Object Model pattern with page Factory

## Overview
This project is intended to use Selenium in Java focusing on Page Object Model (POM) using Page factory. It has been developed using Maven build, Eclipse IDE, JDK 11, and Selenium version 4.15.0. The project aims to automate UI of hamrobazaar web application ( Nepal's Online Marketplace) -https://hamrobazaar.com/

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
4. Add dependency of WebDriverManager in `pom.xml`. (already present in pom.xml but if you are using other version, you need to add)
5. Add dependency of Selenium in `pom.xml`. (already present in pom.xml but if you are using other version, you need to add)
6. Alternatively, download Selenium jar and configure in build path by adding external JARs.
7. As the code is submitted as per POM design pattern, there are two page classes:
   - **Page Class:** Represents a web page, encapsulating its elements and functionalities. (`HamroPage.java`)
   - **Test Class:** Contains test methods that interact with the page elements using the methods provided by the corresponding Page Class. (`TestScriptHamro.java`)
8. Execute `TestScriptHamro.java` as Java Application.
9. CSV file is created in `C:/` drive inside the folder `CSV` (folder is self-created - no need to create one).
10. Data extracted after applying filters are also displayed in tabular format in the console of IDE.
    
## Toubleshooting and Common Issues (To be marked)
1. In case if you are using Eclipse IDE for the very first time, error might arise in pom.xml in **1st line** in last link <span style="background-color: #FFFF00"> "https://maven.apache.org/xsd/maven-4.0.0.xsd"</span> . You need to hover around the link and click on "Force Download".
2. If an operating system other than Windows is in use, the CSV file will not be generated because there is no C: drive (file path for the CSV file has been set to the C: drive in the CSV folder), potentially leading to data not being loaded. To address this issue, it is necessary to modify the **FILE_PATH** in the page class (HamroPage.java) at line 30.
3. If you are using IntelliJ and executing selenium Script for the first time,then Test Automation Plug-in is suggested by IntelliJ you should install it.
   
## Project Structure
1. `project-root 
2. `│ 
3. `├── src (not in use so hidden by Git)
4. `│ ├── main 
5. `│ │ ├── java 
6. `│ │ ├── resources 
7. `│ │
8. `│ ├── test 
9. `│ │ ├── java # Both test class and page class can be found here 
10. `│ │ │ ├── HamroPage.java (Page Class) 
11. `│ │ │ ├── TestScriptHamro.java (Test Class) - Test script to be executed as "Java Application" 
12. `│ │ ├── resources # Test-specific configuration files and resources







