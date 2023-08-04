package pageObjects.wordpress.endUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.wordpress.admin.AdminDashBoardPO;
import pageUIs.wordpress.endUser.UserHomeUI;

public class UserHomePO extends BasePage {
	private WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayWithTitle(String titlePost) {
		waitForElementVisible(driver, UserHomeUI.POST_TITLE, titlePost);
		return isElementDisplayed(driver, UserHomeUI.POST_TITLE, titlePost);

	}

	public boolean isPostInforDisplayWithDateTime(String titlePost, String dateTimePost) {
		waitForElementVisible(driver, UserHomeUI.POST_DATE_TIME, titlePost, dateTimePost);
		return isElementDisplayed(driver, UserHomeUI.POST_DATE_TIME, titlePost, dateTimePost);

	}

	public boolean isPostInforDisplayWithBody(String titlePost, String bodyPost) {
		waitForElementVisible(driver, UserHomeUI.POST_BODY, titlePost, bodyPost);
		return isElementDisplayed(driver, UserHomeUI.POST_BODY, titlePost, bodyPost);

	}

	public boolean isPostInforDisplayWithAuthor(String titlePost, String authorPost) {
		waitForElementVisible(driver, UserHomeUI.POST_AUTHOR, titlePost, authorPost);
		return isElementDisplayed(driver, UserHomeUI.POST_AUTHOR, titlePost, authorPost);

	}

	public void clickToPostTitleByText(String text) {
		waitForClickable(driver, UserHomeUI.POST_TITLE, text);
		clickToElement(driver, UserHomeUI.POST_TITLE, text);

	}

	public boolean isPostDetailInforDisplayWithTitle(String titlePost) {
		waitForElementVisible(driver, UserHomeUI.DETAIL_POST_TITLE, titlePost);
		return isElementDisplayed(driver, UserHomeUI.DETAIL_POST_TITLE, titlePost);

	}

	public boolean isPostDetailInforDisplayWithDateTime(String titlePost, String dateTimePost) {
		waitForElementVisible(driver, UserHomeUI.DETAIL_POST_DATE_TIME, titlePost, dateTimePost);
		return isElementDisplayed(driver, UserHomeUI.DETAIL_POST_DATE_TIME, titlePost, dateTimePost);

	}

	public boolean isPostDetailInforDisplayWithAuthor(String titlePost, String authorPost) {
		waitForElementVisible(driver, UserHomeUI.DETAIL_POST_AUTHOR, titlePost, authorPost);
		return isElementDisplayed(driver, UserHomeUI.DETAIL_POST_AUTHOR, titlePost, authorPost);
	}

	public boolean isPostDetailInforDisplayWithBody(String titlePost, String bodyPost) {
		waitForElementVisible(driver, UserHomeUI.DETAIL_POST_BODY, titlePost, bodyPost);
		return isElementDisplayed(driver, UserHomeUI.DETAIL_POST_BODY, titlePost, bodyPost);
	}

	public void enterToSearchProductByText(String text) {
		waitForElementVisible(driver, UserHomeUI.SEARCH_PRODUCT_TEXTBOX);
		sendKeyToElement(driver, UserHomeUI.SEARCH_PRODUCT_TEXTBOX, text);
		
	}

	public UserSearchProductPO clickToSearchButton() {
		waitForClickable(driver, UserHomeUI.SEARCH_PRODUCT_BUTTON);
		clickToElement(driver, UserHomeUI.SEARCH_PRODUCT_BUTTON);
		return PageGeneratorManager.getUserSearchProduct(driver);
	}



}
