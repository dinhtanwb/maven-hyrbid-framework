package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserChangePasswordUI;
import pageUIs.user.UserHomePageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputOldPassword(String password) {
		waitForElementVisible(driver, UserChangePasswordUI.OLD_PASSWORD);
		sendKeyToElement(driver, UserChangePasswordUI.OLD_PASSWORD, password);
	}

	public void inputNewPassword(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordUI.NEW_PASSWORD);
		sendKeyToElement(driver, UserChangePasswordUI.NEW_PASSWORD, newPassword);
	}

	public void inputConfirmNewPassword(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordUI.CONFIRM_NEW_PASSWORD);
		sendKeyToElement(driver, UserChangePasswordUI.CONFIRM_NEW_PASSWORD, newPassword);
	}

	public void clickToChangePasswordButton() {
		waitForClickable(driver, UserChangePasswordUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordUI.CHANGE_PASSWORD_BUTTON);
	}

	public void changePassword(String password, String newPassword) {
		inputOldPassword(password);
		inputNewPassword(newPassword);
		inputConfirmNewPassword(newPassword);
		clickToChangePasswordButton();
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForClickable(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

}
