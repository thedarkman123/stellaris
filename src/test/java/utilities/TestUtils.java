package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import testcases.BaseTest;

public class TestUtils extends BaseTest {
	public static void captureScreenshot(String fileName,String directory) {
		String pathToFile = System.getProperty("user.dir") + "\\test-output\\html\\" + directory +"\\"+ fileName + ".png";
		try {
			File scrFile = ((TakesScreenshot)getWrapperInstance().getWbInstance()).getScreenshotAs(OutputType.FILE);
			File newFileToCreate = new File(pathToFile);	
			newFileToCreate.getParentFile().mkdirs();
			Files.copy(scrFile, newFileToCreate);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriverWrapper getWrapperInstance() {
		return dw;
	}
	
	public static String generateString(int length){
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rng = new Random();
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++){
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
}
