package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageobject.GenericPageObject;
import utilities.PropertiesWrapper;
import utilities.WebDriverWrapper;

public class BaseTest {
	public static WebDriverWrapper driverWrapper;
	public static Logger log = Logger.getLogger("appLogger");
	
	PropertiesWrapper config,or;

	//initializations goes here
	@BeforeMethod
	public void setup() {
		//a wrapper for properties
		config = new PropertiesWrapper("Config");
		or = new PropertiesWrapper("OR");
		//a wrapper for the webdriver
		driverWrapper = new WebDriverWrapper();
		//here we can add the propery for the browser we initiate the test OR using annotation
		driverWrapper.init(config.getProp("browser")); 

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
