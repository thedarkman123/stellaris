package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageobject.GenericPageObject;
import utilities.PropertiesWrapper;
import utilities.WebDriverWrapper;

public class BaseTest {
	protected static WebDriverWrapper driverWrapper;
	
	protected PropertiesWrapper or; //object repository
	
	protected static String browserInfo;

	public static WebDriverWrapper getWrapperInstance() {
		return driverWrapper;
	}
	//initializations goes here
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		//set it here for later use if needed
		browserInfo = browser;
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//do everything related to closing and removing stuff here
		driverWrapper.quit(); //close the browser		
	}
}
