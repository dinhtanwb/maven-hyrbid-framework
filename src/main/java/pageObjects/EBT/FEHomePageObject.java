package pageObjects.EBT;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.EBT.FEHomePageUI;

public class FEHomePageObject extends BasePage {
	WebDriver driver;

	public FEHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForClickable(driver, FEHomePageUI.LOGIN_LINK);
		clickToElement(driver, FEHomePageUI.LOGIN_LINK);
		
	}

	public void inputEmailAddressTextBox(String textValue) {
		waitForElementVisible(driver, FEHomePageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(driver, FEHomePageUI.EMAIL_ADDRESS_TEXTBOX, textValue);
		
	}

	public void inputPassWordTextBox(String textValue) {
		waitForElementVisible(driver, FEHomePageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, FEHomePageUI.PASSWORD_TEXTBOX, textValue);
		
	}

	public void clickToSignInButton() {
		waitForClickable(driver, FEHomePageUI.SIGN_IN_BUTTON);
		clickToElement(driver, FEHomePageUI.SIGN_IN_BUTTON);
		
	}

	public String getUsernameInLink() {
		waitForElementVisible(driver, FEHomePageUI.USER_NAME_IN_LINK);
		return getElementText(driver, FEHomePageUI.USER_NAME_IN_LINK);
	}

	public void loadDialogSuccess() {
		waitForAllElementInvisible(driver, FEHomePageUI.DIALOG_LOADING);
		
	}
	
}