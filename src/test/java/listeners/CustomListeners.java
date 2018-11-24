package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
		//usually should be logged, but no need for that, so only console printing
		System.out.print(result.getName() + " failed: ");
		System.out.println(result.getThrowable().getMessage().toString());
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
		
	}

}
