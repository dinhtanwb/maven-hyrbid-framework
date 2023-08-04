package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	private WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTitlePage(String pageTitle) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PAGE_TITLE);
		sendKeyToElement(driver, AdminPostAddNewPageUI.PAGE_TITLE, pageTitle);
	}

	public void enterToBodyPage(String bodyPage) {
		waitForClickable(driver, AdminPostAddNewPageUI.PAGE_BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PAGE_BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddNewPageUI.PAGE_BODY_TEXTAREA);
		clearValueElementByPressKey(driver, AdminPostAddNewPageUI.PAGE_BODY_TEXTAREA);
		sendKeyToElement(driver, AdminPostAddNewPageUI.PAGE_BODY_TEXTAREA, bodyPage);
	}

	public void clickToPublishButton() {
		waitForClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
	}
	public void clickToUpdateButton() {
		waitForClickable(driver, AdminPostAddNewPageUI.UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.UPDATE_BUTTON);
	}

	public void clickToRePublishButton() {
		waitForClickable(driver, AdminPostAddNewPageUI.REPUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.REPUBLISH_BUTTON);
		
	}

	public boolean isPublisheOrUpdatesMessageDisplayed(String textPublished) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MSG, textPublished);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.POST_PUBLISHED_MSG, textPublished);
	}

	public AdminPostAllPO openSearchPostPageUrl(String currentURL) {
		driver.get(currentURL);
		return PageGeneratorManager.getAdminPostAllPage(driver);
	}
}
