package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorEmailMessage() {
		waitForElementVisible(driver, UserLoginPageUI.USER_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.USER_EMAIL_ERROR_MESSAGE);
	}

	public UserHomePageObject clickToLoginButton() {
		waitForClickable(driver, UserLoginPageUI.USER_LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.USER_LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public void clickToLoginLink() {
		waitForClickable(driver, UserLoginPageUI.USER_LOGIN_LINK);
		clickToElement(driver, UserLoginPageUI.USER_LOGIN_LINK);
	}

	@Step("Input to Email textBox value: {0}")
	public void inputEmailTextBox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.USER_LOGIN_TEXT_BOX);
		sendKeyToElement(driver, UserLoginPageUI.USER_LOGIN_TEXT_BOX, email);

	}
	@Step("Input to Password textBox value: {0}")
	public void inputPasswordTextBox(String passWord) {
		waitForElementVisible(driver, UserLoginPageUI.USER_PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, UserLoginPageUI.USER_PASSWORD_TEXT_BOX, passWord);

	}

	public String getErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.USER_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.USER_ERROR_MESSAGE);
	}

	public UserHomePageObject loginAsUser(String email, String passWord) {
		inputEmailTextBox(email);
		inputPasswordTextBox(passWord);
		waitForClickable(driver, UserLoginPageUI.USER_LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.USER_LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
