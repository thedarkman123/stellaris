package testcases;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageobject.GenericPageObject;
import utilities.PropertiesWrapper;
import utilities.WebDriverWrapper;

public class BaseTest {
	protected static WebDriverWrapper dw;
	protected PropertiesWrapper or; //object repository
	Logger log = Logger.getLogger("appLogger");
	
	//initializations goes here
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		//a wrapper for properties, or stands for OBJECT REPOSITORY 
		or = new PropertiesWrapper("OR");
		//a wrapper for the webdriver
		dw = new WebDriverWrapper();
		//here we can add the propery for the browser we initiate the test OR using annotation
		dw.init(browser); 

		GenericPageObject.setWebDriver(dw);
		GenericPageObject.setProperties(or);//the only needed properties file
		log.debug("we are going forward");
	}
	
	@AfterMethod
	public void teardown() {
		//do everything related to closing and removing stuff here
		dw.quit(); //close the browser		
	}
}
