package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commons.BasePageFactory;
import pageUIs.user.UserLoginPageUI;

public class LoginPageFactory extends BasePageFactory {
	WebDriver driver;

	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
	}

	// define UI
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement loginTextBox;
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;
	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement errorMessage;

	// define action
	public String getErrorEmailMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void clickToLoginButton() {
		waitForClickable(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public void clickToLoginLink() {
		waitForClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

	public void inputEmailTextBox(String invalidEmail) {
		waitForElementVisible(driver, loginTextBox);
		sendKeyToElement(driver, loginTextBox, invalidEmail);

	}

	public void inputPasswordTextBox(String passWord) {
		waitForElementVisible(driver, passwordTextBox);
		sendKeyToElement(driver, passwordTextBox, passWord);

	}

	public String getErrorMessage() {
		waitForElementVisible(driver, errorMessage);
		return getElementText(driver, errorMessage);
	}
}
