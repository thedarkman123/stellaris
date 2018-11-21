package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.GenericPageObject;
import pageobject.PageObjects;
import pageobject.PageObjects.StellarApplication;
import utilities.PropertiesWrapper;

public class HappyFlowTest extends BasicTest {

	@Test(priority=1)
	public void succesTest() {
		GenericPageObject.openUrl(or.getProp("webUrl"));
		
		//step 1: Career step
		StellarApplication.careerStep();
		    
	    //step 2: Personal information step
	    StellarApplication.personalInformationStep();
	     
	    //step 3: About you step
	    StellarApplication.aboutYouStep();
	    
	    //step 4: Our commitment step
	    StellarApplication.ourCommitmentStep();
	    
	    //step 5: Your commitment step
	    StellarApplication.yourCommitmentStep();
	    
	    //The assert
	    String titleOfLastScreen = driverWrapper
	    		.getElementByType("h2", "tagName", "visible")
	    		.getText();
	    Assert.assertEquals(titleOfLastScreen, or.getProp("titleOfLastScreen"));
	}
	
//	@Test(priority=2)
//	public void failedTest() {
//		GenericPageObject.openUrl(or.getProp("webUrl"));
//	}
}
