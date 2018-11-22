package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testcases.BasicTest;

public class TestUtils extends BasicTest {
	
	public static void captureScreenshot(String methodName) {
		File scrFile = ((TakesScreenshot)driverWrapper.wb).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			System.out.println(System.getProperty("user.dir") + methodName + ".png");
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + methodName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
