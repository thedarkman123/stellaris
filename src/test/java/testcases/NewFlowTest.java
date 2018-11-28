package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.GenericPageObject;
import pageobject.PageObjects.StellarApplication;
import utilities.WebDriverWrapper.CONDITIONTYPE;
import utilities.WebDriverWrapper.FINDTYPE;

public class NewFlowTest extends BaseTest {
	@Test(priority=1)
	public void goodTest() {
		GenericPageObject.openUrl(or.getProp("webUrl"));
		
		dw.typeInElement(
		dw.getPresentElementById("geocomplete"), 
		"something");
		
		dw.selectElementByIndex(
		dw.getPresentElementByXpath("//select[@name='occupation']"),	
		1);
		
//		//step 1: Career step
//		StellarApplication.careerStep();
//		    
//	    //step 2: Personal information step
//	    StellarApplication.personalInformationStep();
//	     
//	    //step 3: About you step
//	    StellarApplication.aboutYouStep();
//	    
//	    //step 4: Our commitment step
//	    StellarApplication.ourCommitmentStep();
//	    
//	    //step 5: Your commitment step
//	    StellarApplication.yourCommitmentStep();
//	    
//	    //The assert
//	    String titleOfLastScreen = driverWrapper
//	    		.getElementByType("h2",FINDTYPE.TAG,CONDITIONTYPE.VISIBLE)
//	    		.getText();
//	    Assert.assertEquals(titleOfLastScreen, or.getProp("titleOfLastScreen"));
	}
	
//	@Test(priority=2)
//	public void failedTest() {
//		GenericPageObject.openUrl(or.getProp("webUrl"));
//		
////		//step 1
////		StellarApplication.chooseOptionOccupationByIndex(1);
////
////		//step 2
////		StellarApplication.goToNextStep();
////		
////		//get this active page id
////	    String titleOfCurrentActivePanel = driverWrapper.getElementByType(or.getProp("currentActivePanelXpath"),FINDTYPE.XPATH,CONDITIONTYPE.PRESENT)
////		.getAttribute("id");
////	    
////	    Assert.assertEquals(titleOfCurrentActivePanel, or.getProp("titleOfPersonalInfoPanel"));
//	}
}
