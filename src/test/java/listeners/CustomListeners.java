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
		Reporter.log(result.getName() + " failed: " + result.getThrowable().getMessage().toString());
		String fileName = result.getName();
		String browserName = TestUtils.getWrapperInstance().getBrowserName();
		TestUtils.captureScreenshot(fileName,browserName);
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
