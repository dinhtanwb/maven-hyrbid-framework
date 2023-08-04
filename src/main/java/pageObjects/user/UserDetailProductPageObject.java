package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserDetailProductPageUI;

public class UserDetailProductPageObject extends BasePage{
	WebDriver driver;

	public UserDetailProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserDetailReviewPageObject addYourReview() {
		waitForClickable(driver, UserDetailProductPageUI.ADD_YOUR_PREVIEW_LINK);
		clickToElement(driver, UserDetailProductPageUI.ADD_YOUR_PREVIEW_LINK);
		return PageGeneratorManager.getDetailReviewPage(driver);
	}
	
}
