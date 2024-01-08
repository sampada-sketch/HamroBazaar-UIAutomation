package com.automate.learn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamroPage {
	
	   @FindBy(css="input[type='search']")
	   private WebElement searchbox;
	   
	   @FindBy(xpath="//button[@type='submit']")
	   private WebElement buttonClick;
	   
	   @FindBy(xpath="//input[@name='location']")
	   private WebElement location;

	   

	    public HamroPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    	
	    }
	      
	  public void searchItem(String monitor)
	  {
		  searchbox.sendKeys(monitor);
	  }
	  
	  public void clickMe()
	  {
		  buttonClick.click();
	  }
	    
	

}
