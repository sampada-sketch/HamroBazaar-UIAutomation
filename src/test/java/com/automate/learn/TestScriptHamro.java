package com.automate.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScriptHamro {

	public static void main(String args[]) throws InterruptedException
	{
		//Instantiate the chromedriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Created the object of HamroPage (class where we have stored objects of webElements and created methods for those webElements
		HamroPage mainPage = new HamroPage(driver);
		driver.get("https://hamrobazaar.com/");
		mainPage.searchItem("monitor");
		mainPage.clickMe();
		mainPage.locationFilter("NewRoad");
		mainPage.DropdownMe();
		mainPage.locationRadius();
		mainPage.sortMe();
		mainPage.getProductsDetails();
		
		teardown(driver);
	}
	
	//Method to quit the driver session 
	public static void teardown(WebDriver driver)
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
