package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageObjects  {

	public static class StellarApplication extends GenericPageObject{
		
		//step 1
		public static void careerStep() {
			enterCity(propertiesWrapper.getProp("cityToEnter"));
			openAndChooseOptionOccupationByIndex(1);
			openAndChooseUserStatusByIndex(1);
			goToNextStep();
		}
		
		//step 2
		public static void personalInformationStep() {
			enterFirstName(propertiesWrapper.getProp("userFirstName"));
			enterLastName(propertiesWrapper.getProp("userLastName"));
			enterPhone(propertiesWrapper.getProp("userPhoneNumber"));
			enterEmail(propertiesWrapper.getProp("userEmail"));
			goToNextStep();
		}
		
		//step 3 
		public static void aboutYouStep() {
			enterLinkedIn(propertiesWrapper.getProp("linkedInTxt"));
			goToNextStep();
		}
		
		//step 4
		public static void ourCommitmentStep() {
			driverWrapper.getElementById(propertiesWrapper.getProp("ourcommitmentsStepId"));		
			goToNextStep();
		}
		
		//step 5
		public static void yourCommitmentStep() {
			checkAllCheckboxes();
			clickSubmit();
		}
		
		//Your commitment functions
		public static void checkAllCheckboxes() {
			List<WebElement> els = driverWrapper
			.getElements(propertiesWrapper
			.getProp("checkboxesXpath"));
			for (WebElement el : els) {
				el.click();
			}
		}
		
		//About you functions
		public static void enterLinkedIn(String linkedIn) {
			driverWrapper
			.getElementById(propertiesWrapper.getProp("linkInId"))
			.sendKeys(linkedIn);
		}
		
		//Personal information functions
		public static void enterFirstName(String firstName) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("userFirstNameId"))
			.sendKeys(firstName);
		}
		
		public static void enterLastName(String lastName) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("userLastNameId"))
			.sendKeys(lastName);
		}
			
		public static void enterPhone(String phone) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("userPhoneNumberId"))
			.sendKeys(phone);
		}
		
		public static void enterEmail(String email) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("userEmailAddressInput"))
			.sendKeys(email);
		}
		
		public static void enterCity(String randTxt) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("cityNameInputId"))
			.sendKeys(randTxt);
		}
		
		//Career functions
		public static void openAndChooseOptionOccupationByIndex(int optionNum) {
			//This is because of firefox
			String optionToChooseXpath = propertiesWrapper.getProp("userOccupationSpecificXpath")
			.replace("1", Integer.toString(optionNum));
			driverWrapper.getElementByType(propertiesWrapper.getProp("userOccupationId"),"id","presence")
			.click();
			driverWrapper.getElementByType(
			optionToChooseXpath,"xpath","visible")
			.click();			
//		    Select s = new Select(driverWrapper
//		    		    .get_Element(By.xpath(propertiesWrapper
//						.getProp("userOccupationSelectXpath"))));
//			s.selectByIndex(optionNum);  
		}
		
		public static void openAndChooseUserStatusByIndex(int optionNum) {
			//This is because of firefox
			String optionToChooseXpath = propertiesWrapper.getProp("userStatusSpecificXpath")
					.replace("1", Integer.toString(optionNum));
			driverWrapper.getElementByType(propertiesWrapper.getProp("userStatusId"),"id","presence")
			.click();
			driverWrapper.getElementByType(
			optionToChooseXpath
			,"xpath","visible")
			.click();			
//		    Select s = new Select(driverWrapper
//	    		    .get_Element(By.xpath(propertiesWrapper
//					.getProp("userStatusSelectXpath"))));
//			s.selectByIndex(optionNum);		
		}
		
		//General functions
		public static void goToNextStep() { 
			driverWrapper.getElementByXpath(
			propertiesWrapper.getProp("nextButtonXpath"))
			.click();	
		}
		
		
		public static void clickSubmit() { 
			driverWrapper.getElementByXpath(
			propertiesWrapper.getProp("submitButtonXpath"))
			.click();	
		}
		
	}
	
}
