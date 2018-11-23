package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import testcases.BaseTest;

public class TestUtils extends BaseTest {
	
	public static void captureScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot)driverWrapper.getWbInstance()).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile, new File(System.getProperty("user.dir") + "\\test-output\\html\\"+ fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
