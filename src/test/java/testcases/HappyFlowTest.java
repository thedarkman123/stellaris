package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.GenericPageObject;
import pageobject.PageObjects.StellarApplication;
import utilities.WebDriverWrapper.CONDITIONTYPE;
import utilities.WebDriverWrapper.FINDTYPE;

public class HappyFlowTest extends BaseTest {

	@Test(priority=1)
	public void completeFlowTest() {
//		GenericPageObject.openUrl(or.getProp("webUrl"));
//		
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
//	    String titleOfLastScreen = dw
//	    		.getElementByType("h2",FINDTYPE.TAG,CONDITIONTYPE.VISIBLE)
//	    		.getText();
//	    Assert.assertEquals(titleOfLastScreen, or.getProp("titleOfLastScreen"));
	}
	
	@Test(priority=2)
	public void missingInfoTest() {
//		GenericPageObject.openUrl(or.getProp("webUrl"));
//		
//		//step 1
//		StellarApplication.chooseOptionOccupationByIndex(1);
//
//		//step 2
//		StellarApplication.goToNextStep();
//		
//		//get this active page id
//	    String titleOfCurrentActivePanel = dw.getElementByType(or.getProp("currentActivePanelXpath"),FINDTYPE.XPATH,CONDITIONTYPE.PRESENT)
//		.getAttribute("id");
//	    
//	    Assert.assertEquals(titleOfCurrentActivePanel, or.getProp("titleOfPersonalInfoPanel"));
	}
}
