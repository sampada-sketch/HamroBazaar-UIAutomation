# UI Automation - HamroBazaar search using Selenium 4.15.0 with Java Focusing on Page Object Model pattern with page Factory

## Software Requirements:
1. **Eclipse or IntelliJ**
2. **Jdk 8 or above** (I am using Jdk 11)
3. **Maven project** (Available in Eclipse)
4. **Dependency of WebDriverManager:** [WebDriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager) (I am using version 5.6.3)
5. **Selenium dependency or jar file version**
6. **Chrome Browser driver is not required** as this project is implemented using `WebDriverManager()` method

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
