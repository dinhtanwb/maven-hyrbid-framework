package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Click to Register button")
	public void clickToRegisterButton() {
		waitForClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}
	
	public UserHomePageObject clickToLogouLink() {
		waitForClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return new UserHomePageObject(driver);
	}

	public String getFirstNameError() {
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);

	}

	public String getEmailError() {
		waitForAllElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getLastNameError() {
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getPasswordError() {
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getConfirmError() {
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASS_ERROR_MESSAGE);
	}
	@Step("Input to FirstName textBox value: {0}")
	public void inputFirstNameTextBox(String string) {
		sendKeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXT, string);
	}
	@Step("Input to LastName textBox value: {0}")
	public void inputLastNameTextBox(String string) {
		sendKeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXT, string);
	}
	@Step("Input to Email textBox value: {0}")
	public void inputEmailTextBox(String emailAddress) {
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TEXT, emailAddress);

	}
	@Step("Input to Password textBox value: {0}")
	public void inputPasswordTextBox(String string) {
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT, string);
	}
	@Step("Input to ConfirmPassword textBox value: {0}")
	public void inputConfirmPasswordTextBox(String string) {
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT, string);

	}

	public String getEmailExitingMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_EMAIL_EXISTING_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_EMAIL_EXISTING_MESSAGE);
	}
	@Step("Verify email success message")
	public String getEmailSuccessMessage() {
		waitForAllElementVisible(driver, UserRegisterPageUI.REGISTER_EMAIL_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_EMAIL_SUCCESS_MESSAGE);
	}
	public UserHomePageObject registerAccount(String firstName, String lastName, String email, String password) {
		inputFirstNameTextBox(firstName);
		inputLastNameTextBox(lastName);
		inputEmailTextBox(email);
		inputPasswordTextBox(password);
		inputConfirmPasswordTextBox(password);
		clickToRegisterButton();
		return PageGeneratorManager.getUserHomePage(driver);
	}



	
}
