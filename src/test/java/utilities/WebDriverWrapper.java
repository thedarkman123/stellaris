package utilities;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WebDriverWrapper {
	
	private WebDriver wb = null;
	
	public WebDriver getWbInstance() {
		return this.wb;
	}
	
	public String getBrowserName() {
	    Capabilities cap = ((RemoteWebDriver) this.wb).getCapabilities();
	    return cap.getBrowserName().toLowerCase();
	}
	
	public String getPlatform() {
		Capabilities cap = ((RemoteWebDriver) this.wb).getCapabilities();
		return cap.getPlatform().toString();
	}
	
	public String getVersion() {
		Capabilities cap = ((RemoteWebDriver) this.wb).getCapabilities();
		return cap.getVersion().toString();
	}

	public void init(String browser) {
		if (browser.equals("chrome")) {
			//set a default one, no matter which one
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\src\\test\\resources\\excutables\\chromedriver.exe");
			wb = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")+"\\src\\test\\resources\\excutables\\geckodriver.exe");
			wb = new FirefoxDriver(); 
		}
	}

	public void openUrl(String url) {
		wb.get(url);
	}
	
	public static enum FINDTYPE{
		XPATH,ID,TAG
	}
	
	public static enum CONDITIONTYPE{
		VISIBLE,CLICKABLE,PRESENT
	}

	//explicit wait find
	public WebElement getElementByType(String value, FINDTYPE type, CONDITIONTYPE condition) {
		WebElement element = null;

		By by = null;

		if (type == FINDTYPE.XPATH) {
			by = By.xpath(value);
		} else if (type == FINDTYPE.ID) {
			by = By.id(value);
		} else if(type == FINDTYPE.TAG) {
			by = By.tagName(value);
		}

		try {
			WebDriverWait driverWait = new WebDriverWait(wb, 20, 1000);
			//default
			if (condition == CONDITIONTYPE.PRESENT) {
				element = driverWait.until(ExpectedConditions.presenceOfElementLocated(by));	
			} else if (condition == CONDITIONTYPE.CLICKABLE) {
				element = driverWait.until(ExpectedConditions.elementToBeClickable(by));
			} else if (condition == CONDITIONTYPE.VISIBLE) {
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
		return getElementByType(id,FINDTYPE.ID,CONDITIONTYPE.VISIBLE);
	}
	
	public WebElement getElementByXpath(String xpath) {
		return getElementByType(xpath,FINDTYPE.XPATH,CONDITIONTYPE.VISIBLE);
	}

	public void quit() {
		wb.quit();
	}

}
