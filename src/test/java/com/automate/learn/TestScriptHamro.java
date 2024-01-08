package com.automate.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScriptHamro {

    private WebDriver driver;
    private HamroPage hamropage;

    @BeforeTest
    public void setup() {
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(getFirefoxProfile());

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sampada.suwal\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        // Assign the created WebDriver instance to the class-level variable
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://hamrobazaar.com/");

        hamropage = new HamroPage(driver);
    }

    private FirefoxProfile getFirefoxProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("geo.enabled", false);
        return profile;
    }

    @Test
    public void searchMe() {
        hamropage.searchItem("Monitor");
        hamropage.clickMe();
    }
}
