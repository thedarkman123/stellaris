package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testcases.BaseTest;
import utilities.TestUtils;

public class CustomListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName().toString() + " success");
	}

	public void onTestFailure(ITestResult result) {	
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String fileName    = result.getName() + TestUtils.getCurrentTimeForScreenshot();
		String browserName = TestUtils.getWrapperInstance().getBrowserName();
		String pathToFile  = TestUtils.captureScreenshot(fileName,browserName);
		Reporter.log("<br>");
		Reporter.log(result.getName() + " failed: " + result.getThrowable().getMessage().toString());
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + pathToFile + ">Screenshot</a>");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Tests done");
	}

}
