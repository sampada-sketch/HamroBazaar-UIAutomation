package com.automate.learn;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//Utilized this class to practice locating elements for implementing the Page Object Model (POM).
public class AutomationWithoutPOM {

	public static void main(String[] args) throws InterruptedException {
		// set the property to specify the path of chromedriver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver.exe");
		// create an instance of chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hamrobazaar.com/");
		WebElement searchbox = driver.findElement(By.cssSelector("input[type='search']"));
		searchbox.sendKeys("Monitor");
		searchbox.submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Corrected XPath expression for locationInput
		WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='input--wrapper pos-rel ']/descendant::input[@name='location'])[2]")));

		// Corrected XPath expression for locationInput
		// WebElement locationInput =
		// driver.findElement(By.xpath("(//div[@class='input--wrapper pos-rel
		// ']/descendant::input[@name='location'])[2]")); // Replace with the actual ID
		// or another locator

		// Type the location name
		locationInput.sendKeys("Newroad");
		// Wait for the dropdown to appear (adjust the timeout and other conditions as
		// needed)
		WebElement dropdownOption = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.place--suggestions li:nth-child(2)")));
		Actions actions = new Actions(driver);

		// Perform mouse hover over the desired dropdown option
		actions.moveToElement(dropdownOption).click().build().perform();

		WebElement slider = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='rs-slider-handle'])[2]")));

		actions.clickAndHold(slider).moveByOffset(145, 0) // Adjusting the offset as 145 as it slides to "4996"
				.release().perform();

		Thread.sleep(2000);
		// Performing keyboard's "key arrow right" click for 4 times resulting
		// 4996+4=5000 to be reached by slider
		for (int i = 0; i < 4; i++) {
			actions.sendKeys(slider, Keys.ARROW_RIGHT).perform();
		}

		WebElement sorting = driver.findElement(By.xpath("(//select[@class='input'])[5]"));
		Select select = new Select(sorting);
		select.selectByIndex(3);

	}

}
