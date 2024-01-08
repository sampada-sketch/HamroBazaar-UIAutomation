package com.automate.learn;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class HamroPage {

	private final WebDriver driver;
	private final WebDriverWait wait;
	private final Actions actions; // For method 01 example of locationRadius()
	private static String FILE_PATH = "C://CSV//Search_Result.csv";

	// Constructor initializes the class with WebDriver and sets up PageFactory
	public HamroPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // setting duration of 5 seconds as per required
		PageFactory.initElements(driver, this);
	}

	// Locators using @FindBy annotation
	@FindBy(css = "input[type='search']")
	private WebElement searchbox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonClick;

	@FindBy(xpath = "(//div[@class='input--wrapper pos-rel ']/descendant::input[@name='location'])[2]")
	private WebElement locationInput;

	@FindBy(css = "div.place--suggestions li:nth-child(2)")
	private WebElement dropDown;

	@FindBy(xpath = "(//div[@class='rs-slider-handle'])[2]")
	private WebElement slider;

	@FindBy(xpath = "(//select[@class='input'])[5]")
	private WebElement sorting;

	@FindBy(css = "h2.product-title")
	private List<WebElement> monitorNames;

	@FindBy(css = "span.regularPrice")
	private List<WebElement> monitorPrices;

	@FindBy(css = "p.description")
	private List<WebElement> monitordesc;

	@FindBy(css = "span.condition")
	private List<WebElement> monitorcondt;

	@FindBy(css = "span.time")
	private List<WebElement> adposted;

	@FindBy(css = "span.username-fullname")
	private List<WebElement> sellers;

	// Method to search for an item i.e "Monitor"
	public void searchItem(String monitor) {
		searchbox.sendKeys(monitor);
	}

	// Method to click the search button
	public void clickMe() {
		buttonClick.click();
	}

	// Method to send location i.e "NewRoad" in Location field
	public void locationFilter(String placeName) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(locationInput));
		locationInput.sendKeys(placeName);
	}

	/* Method to select "naya sadak newroad, New Road, Kathmandu" location from
	 location options*/
	public void DropdownMe() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(dropDown));
		actions.moveToElement(dropDown).click().build().perform();
	}

	// Method to set the location radius
	public void locationRadius() {
		// -----------------------------------------------------------------------------------------
		// Method 01: using static xoffset value of the web element
		// Note: This wont be feasible for every screen resolution
		// START OF THE CODE:

		/*
		 * wait.until(ExpectedConditions.visibilityOf(slider));
		 * actions.clickAndHold(slider) .moveByOffset(145, 0) // Adjusting the offset as
		 * 145 as it slides to "4996" .release() .perform();
		 * 
		 * //Performing keyboard's "key arrow right" click for 4 times resulting
		 * 4996+4=5000 to be reached by slider for (int i = 0; i < 4; i++) {
		 * actions.sendKeys(slider, Keys.ARROW_RIGHT).perform(); }
		 */

		// -----------------------------------------------------------------------------------------
		/* Method 02: using javascriptExceutor - dynamic procedure for every screen
		   resolution also JavascriptExecutor accepts value in int,double,etc.
		 */
		// Note: xoffset of "5000" location radius is "42.3684" (style= left:42.3684%)
		// JavaScriptExecutor is used to dynamically set the left style of the slider
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.left='" + 47.3684 + "%'", slider);
	}

	// Method to sort the results by "low to high" price
	public void sortMe() {
		Select select = new Select(sorting);
		select.selectByIndex(3); //Filter "low to high" price is in Index 3 if used selectByIndex method
	}

	// Method to get product details
	public void getProductsDetails() {
		// Detects whether the monitorElements are present or not
		List<WebElement> monitorElements = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy
						(By.xpath("//div[@class='card-product-linear']/descendant::div[@class='card-product-linear-info']")));
	
		List<String> productDetails = new ArrayList<>();
		int itemCounts = Math.min(monitorElements.size(), 50);

		// Iterate over the list of monitor elements
		for (int i = 0; i < itemCounts; i++) {
			// Extract information for the i-th monitor over the iteration
			//Since Commas in the text separates the column in CSV file, needed to replace it with whitespace
			String monitorName = monitorNames.get(i).getText().replace(",", ""); 
			//Symbol "रू" was not recognized by CSV so had to replace it with Rs.
			String monitorPrice = monitorPrices.get(i).getText().replace(",", "").replace("रू", "Rs");
			String description = monitordesc.get(i).getText().replace(",", "");
			String monitorcondts = monitorcondt.get(i).getText().replace(",", "");
			String ad = adposted.get(i).getText().replace(",", "");
			String seller = sellers.get(i).getText().replace(",", "");
			// Format the extracted information and add it to the productDetails list
			productDetails.add(String.format("%s,%s,%s,%s,%s,%s", monitorName, monitorPrice, description, monitorcondts,
					ad, seller));
		}
		// call the method where details are written to CSV file
		writeDetailsToCSV(productDetails);
		//call the method to display details in tabular form in console
		try {
			displayCSVTabular();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method to write details to CSV file (parameter - A collection of strings
	 * named "detail" is created, and the extracted monitor details are added to
	 * this list, which corresponds to the "productDetails" list.)
	 */
	private void writeDetailsToCSV(List<String> details) {
		// checks if folder is present, if not makes a directory
		File f1 = new File("C://CSV");
		if (!f1.exists()) {
			f1.mkdir();
		}
		// creating object of file writer
		try (FileWriter csvWriter = new FileWriter(FILE_PATH)) {
			// Appending Headers to the CSV
			csvWriter.append("Monitor Name,Monitor Price, Description, Condition, Ad posted, Name of seller \n");
			for (String detail : details) {
				// Writing each data into CSV available in productDetails
				csvWriter.append(detail + "\n");
			}
			System.out.println(
					"Monitor details collected and written to Search_Result.csv inside CSV folder in a C:/ Drive\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to display CSV data in tabular format in console
	private void displayCSVTabular() throws CsvException {
		// created object of CSV reader to read the details present in the file
		try (CSVReader csvReader = new CSVReader(new FileReader(FILE_PATH))) {

			// Read all rows from the CSV file and store them in a list of string arrays
			List<String[]> data = csvReader.readAll();
			// Extract the header row from the data
			String[] header = data.get(0);
			// call the method to Print the header row
			printRow(header);
			// Iterate through the rows starting from the second row (index 1)
			for (int i = 1; i < data.size(); i++) {
				// Extract the current row
				String[] row = data.get(i);

				// Print the current row
				printRow(row);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Helper method to print a row in tabular format
	private static void printRow(String[] row) {
		// Iterate through each cell in the current row
		for (String cell : row) {
			// Print the content of the current cell followed by tabs
			System.out.print(cell + "\t\t");
		}

		// Move to the next line after printing all cells in the row
		System.out.println();

	}

}
