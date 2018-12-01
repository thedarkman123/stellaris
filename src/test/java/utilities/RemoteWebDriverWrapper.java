package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class RemoteWebDriverWrapper {
	//for thread context, seperate the instances of the program
		public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
		
		private RemoteWebDriver rwb = null;
		
		public void init(String browser,String remoteHubUrl) throws MalformedURLException {
			DesiredCapabilities cap = null;
			if (browser.equals("chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("ie")) {
				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("ieplorer");
				cap.setPlatform(Platform.WINDOWS);
			}
			
			rwb = new RemoteWebDriver(new URL(remoteHubUrl),cap);
			
		}
}
