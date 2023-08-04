package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public AdminDashboardPageObject login_As_Admin_Role(String emailTextBox, String passwordTextBox) {
		inputEmailTexBox(emailTextBox);
		inputPasswordTextBox(passwordTextBox);
		return clickToLoginButton();
	}
	public void inputEmailTexBox(String emailTextBox) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXT_BOX);
		sendKeyToElement(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXT_BOX, emailTextBox);
	}
	public void inputPasswordTextBox(String passwordTextBox) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXT_BOX);
		sendKeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXT_BOX, passwordTextBox);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
}
