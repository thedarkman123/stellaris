package pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;

public class PageObjects  {

	public static class StellarApplication extends GenericPageObject{
		
		//step 1
		public static void careerStep() {
			enterCity(propertiesWrapper.getProp("cityToEnter"));
			openAndChooseOptionOccupation();
			openAndChooseUserStatus();
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
			//just this one time, check for a different condition :)
			driverWrapper
			.getElementById(propertiesWrapper
			.getProp("ourcommitmentsStepId"));
			goToNextStep();
		}
		
		//step 5
		public static void yourCommitmentStep() {
			checkAllCheckboxes();
			clickSubmit();
		}
		
		private static void checkAllCheckboxes() {
			List<WebElement> els = driverWrapper
			.getElements(propertiesWrapper
			.getProp("checkboxesXpath"));
			for (WebElement el : els) {
				el.click();
			}
		}
		
		private static void enterLinkedIn(String linkedIn) {
			driverWrapper
			.getElementById(propertiesWrapper.getProp("linkInId"))
			.sendKeys(linkedIn);
		}
		
		private static void enterFirstName(String firstName) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("userFirstNameId"))
			.sendKeys(firstName);
		}
		
		private static void enterLastName(String lastName) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("userLastNameId"))
			.sendKeys(lastName);
		}
			
		private static void enterPhone(String phone) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("userPhoneNumberId"))
			.sendKeys(phone);
		}
		
		private static void enterEmail(String email) { //can be multiple possiblities here
			driverWrapper
			.getElementById(propertiesWrapper.getProp("userEmailAddressInput"))
			.sendKeys(email);
		}
		
		private static void enterCity(String randTxt) { //can be multiple possiblities here
			System.out.println(randTxt);
			driverWrapper
			.getElementById(propertiesWrapper.getProp("cityNameInputId"))
			.sendKeys(randTxt);
		}
		
		private static void openAndChooseOptionOccupation() {
			//action 1 = open the box
			driverWrapper
			.getElementByXpath(propertiesWrapper
			.getProp("userOccupationXpath"))
			.click();	
			
			//action 2 = choose the option
			driverWrapper
			.getElementByXpath(propertiesWrapper
			.getProp("userOccupationOptionToChooseXpath"))
			.click();			
		}
		
		private static void openAndChooseUserStatus() {
			//action 1 = open the box
			driverWrapper
			.getElementByXpath(propertiesWrapper
			.getProp("userStatusXpath"))
			.click();	
			
			//action 2 = choose the option
			driverWrapper
			.getElementByXpath(propertiesWrapper
			.getProp("userStatusOptionToChooseXpath"))
			.click();	
		}
		
		private static void goToNextStep() { 
			driverWrapper.getElementByXpath(
			propertiesWrapper.getProp("nextButtonXpath"))
			.click();	
		}
		
		private static void clickSubmit() { 
			driverWrapper.getElementByXpath(
			propertiesWrapper.getProp("submitButtonXpath"))
			.click();	
		}
		
	}
	
}
