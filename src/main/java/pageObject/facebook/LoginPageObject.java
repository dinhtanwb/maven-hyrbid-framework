package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void clickToLoginButton() {
		waitForClickable(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_ACCOUNT_BUTTON);
	}
	public boolean isDisplayFirstNameTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXT_BOX);
	}
	public void sendkeyToEmailTextBox(String textValue) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, textValue);
	}
	public boolean isDisplayConfirmEmailTextBox(String textValue) {
		return isElementDisplayed(driver, LoginPageUI.DYNAMIC_TEXT_BOX, textValue);
	}
	public void closeTheForm() {
		waitForClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}
	public boolean isTextBoxUnDisplay(String textValue) {
		return isElementUnDisplayed(driver, LoginPageUI.DYNAMIC_TEXT_BOX, textValue);
		
	}
}
