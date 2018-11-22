package utilities;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WebDriverWrapper {
	
	public WebDriver wb = null;

	public void init(String browser) {
//		DesiredCapabilities dr = DesiredCapabilities.chrome();
//		capabilities.setCapability("overlappingCheckDisabled", true);
		if (browser.equals("chrome")) {
			//set a default one, no matter which one
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\src\\test\\resources\\excutables\\chromedriver.exe");
			wb = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			//disable the overlapping errors
			FirefoxOptions capabilities = new FirefoxOptions();
			capabilities.setCapability("overlappingCheckDisabled", true);
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")+"\\src\\test\\resources\\excutables\\geckodriver.exe");
			wb = new FirefoxDriver(capabilities); 
		}
	}

	public void openUrl(String url) {
		wb.get(url);
	}

	//explicit wait find
	public WebElement getElementByType(String value, String type, String condition) {
		WebElement element = null;

		By by = null;

		if (type.equals("xpath")) {
			by = By.xpath(value);
		} else if (type.equals("id")) {
			by = By.id(value);
		} else if(type.equals("tagName")) {
			by = By.tagName(value);
		}

		try {
			WebDriverWait driverWait = new WebDriverWait(wb, 20, 1000);
			//default
			element = driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
			if (condition.equals("clickable")) {
				element = driverWait.until(ExpectedConditions.elementToBeClickable(by));
			} else if (condition.equals("visible")) {
				element = driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
			}

		} catch (TimeoutException e) {
			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (element == null) {
			Assert.fail();
		}

		return element;

	}
	
	public List<WebElement> getElements(String value) {
		List<WebElement> elements = null;
		By by = By.xpath(value);
		try {
			WebDriverWait driverWait = new WebDriverWait(wb, 20, 1000);
			//default
			elements = driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

		} catch (TimeoutException e) {
			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (elements == null) {
			Assert.fail();
		}

		return elements;
	}


	//simple find
	public WebElement get_Element(By by) {
		WebElement element = wb.findElement(by);

		if (element != null) {
			return element;
		} else
			return null;

	}
	
	public WebElement getElementById(String id) {
		return getElementByType(id,"id","visible");
	}
	
	public WebElement getElementByXpath(String xpath) {
		return getElementByType(xpath,"xpath","visible");
	}

	public void quit() {
		wb.quit();
	}

}
