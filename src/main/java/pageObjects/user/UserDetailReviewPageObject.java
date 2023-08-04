package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserDetailPageUI;

public class UserDetailReviewPageObject extends BasePage{
	WebDriver driver;
	public UserDetailReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDisplayHeader(String headerPage) {
		return isElementDisplayed(driver, BasePage.locator_1_Parameter(UserDetailPageUI.TITLE_REVIEW_PAGE, headerPage));
	}
	public void inputReviewTitle(String reviewTitleText) {
		waitForElementVisible(driver, UserDetailPageUI.REVIEW_TITLE_TEXT_BOX);
		sendKeyToElement(driver, UserDetailPageUI.REVIEW_TITLE_TEXT_BOX, reviewTitleText);
	}
	public void inputReviewText(String reviewText) {
		waitForElementVisible(driver, UserDetailPageUI.REVIEW_TEXT_TEXT_BOX);
		sendKeyToElement(driver, UserDetailPageUI.REVIEW_TEXT_TEXT_BOX, reviewText);
	}
	public void clickToSubmitButton() {
		waitForElementVisible(driver, UserDetailPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserDetailPageUI.SUBMIT_BUTTON);
	}
	public void addYourReview(String reviewTitleText, String reviewText) {
		inputReviewTitle(reviewTitleText);
		inputReviewText(reviewText);
		clickToSubmitButton();
	}
}
