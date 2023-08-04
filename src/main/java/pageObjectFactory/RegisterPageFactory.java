package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePageFactory;
import pageUIs.user.UserRegisterPageUI;

public class RegisterPageFactory extends BasePageFactory{
	WebDriver driver;

	public RegisterPageFactory(WebDriver driver) {
		this.driver = driver;
	}
	//define UI
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameText;
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameText;
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailText;
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordText;
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordText;
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerEmailSuccessMessage;
	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement registerEmailExistingMessage;
	
	//define action

	public void clickToRegisterButton() {
		waitForClickable(driver,registerButton);
		clickToElement(driver, registerButton);
	}

	public String getFirstNameError() {
		return getElementText(driver, firstNameErrorMessage);

	}

	public String getEmailError() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getLastNameError() {
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getPasswordError() {
		return getElementText(driver, passwordErrorMessage);
	}

	public String getConfirmError() {
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputFirstNameTextBox(String string) {
		sendKeyToElement(driver, firstNameText, string);
	}

	public void inputLastNameTextBox(String string) {
		sendKeyToElement(driver, lastNameText, string);
	}

	public void inputEmailTextBox(String emailAddress) {
		sendKeyToElement(driver, emailText, emailAddress);

	}

	public void inputPasswordTextBox(String string) {
		sendKeyToElement(driver, passwordText, string);
	}

	public void inputConfirmPasswordTextBox(String string) {
		sendKeyToElement(driver, confirmPasswordText, string);

	}

	public String getEmailExitingMessage() {
		waitForElementVisible(driver, registerEmailExistingMessage);
		return getElementText(driver, registerEmailExistingMessage);
	}

	public String getEmailSuccessMessage() {
		waitForElementVisible(driver,registerEmailSuccessMessage);
		return getElementText(driver, registerEmailSuccessMessage);
	}

}
