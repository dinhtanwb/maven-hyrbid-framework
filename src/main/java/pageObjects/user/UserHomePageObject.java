package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	@Step("Click to Register link")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		//Cách 2
//		return new RegisterPageObject(driver);
		//cách 3:
		return PageGeneratorManager.getRegisterPage(driver);
	}
	public UserLoginPageObject clickToLoginLink() {
		waitForClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}
	public String getMyAccountText() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		return getElementText(driver, UserHomePageUI.MYACCOUNT_LINK);
	}

//	public CustomerInfoPageObject clickToMyAccountLink() {
//		return;
//	}
	public UserCustomerInfoPageObject clicktoMyAccountLink() {
		waitForClickable(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
		
	}
	public void clickToLogoutLink() {
		waitForClickable(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
		
	}
	
	
}
