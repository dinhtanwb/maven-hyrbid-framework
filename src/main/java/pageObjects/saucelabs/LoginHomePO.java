package pageObjects.saucelabs;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saucelabs.LoginHomePageUI;

public class LoginHomePO extends BasePage{

	WebDriver driver;
	public LoginHomePO(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToUserNameTextBox(String text) {
		waitForElementVisible(driver, LoginHomePageUI.USERNAME_TEXTBOX);
		sendKeyToElement(driver, LoginHomePageUI.USERNAME_TEXTBOX, text);
	}
	public void enterToPasswordTextBox(String text) {
		waitForElementVisible(driver, LoginHomePageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginHomePageUI.PASSWORD_TEXTBOX, text);		
	}
	public HomePO clicktoLoginButton() {
		waitForClickable(driver, LoginHomePageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginHomePageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePO(driver);
	}

}
