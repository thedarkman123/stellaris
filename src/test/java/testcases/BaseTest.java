package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageobject.GenericPageObject;
import utilities.PropertiesWrapper;
import utilities.WebDriverWrapper;

public class BaseTest {
	protected static WebDriverWrapper driverWrapper;
	protected PropertiesWrapper or; //object repository

	public static WebDriverWrapper getWrapperInstance() {
		return driverWrapper;
	}
	//initializations goes here
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		//a wrapper for properties
		or = new PropertiesWrapper("OR");
		//a wrapper for the webdriver
		driverWrapper = new WebDriverWrapper();
		//here we can add the propery for the browser we initiate the test OR using annotation
		driverWrapper.init(browser); 

		GenericPageObject.setWebDriver(driverWrapper);
		GenericPageObject.setPropertiesDriver(or);//the only needed properties file
	}
	
	@AfterMethod
	public void teardown() {
		//do everything related to closing and removing stuff here
		driverWrapper.quit(); //close the browser		
	}
}