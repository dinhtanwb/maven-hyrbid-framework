package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;
import pageUIs.wordpress.admin.AdminPostAllPageUI;

public class AdminPostAllPO extends BasePage {
	private WebDriver driver;

	public AdminPostAllPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementVisible(driver, AdminPostAllPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostAllPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostNewPage(driver);
	}

	public void enterToSearchTextBox(String titlePage) {
		waitForElementVisible(driver, AdminPostAllPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, AdminPostAllPageUI.SEARCH_TEXTBOX, titlePage);
		
	}

	public void clickToSearchPostsButton() {
		waitForClickable(driver, AdminPostAllPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostAllPageUI.SEARCH_BUTTON);		
	}

	public String isDisplayTextByNameColumn(String nameColumn) {
		int indexColumn = getElementSize(driver, AdminPostAddNewPageUI.COLUMN_INDEX_BY_TEXT, nameColumn) + 1;
		waitForElementVisible(driver, AdminPostAddNewPageUI.TEXTBOX_BY_COLUMN_INDEX_ROW_INDEX, String.valueOf(indexColumn));
		return getElementText(driver, AdminPostAddNewPageUI.TEXTBOX_BY_COLUMN_INDEX_ROW_INDEX, String.valueOf(indexColumn));
	}

	public AdminPostAddNewPO clickToPostTitleInRowByText(String postTitle) {
		waitForElementVisible(driver, AdminPostAllPageUI.POST_TITLE_IN_ROW, postTitle);
		clickToElement(driver, AdminPostAllPageUI.POST_TITLE_IN_ROW, postTitle);
		return PageGeneratorManager.getAdminPostNewPage(driver);
	}

	public void selectPostInRowByText(String titlePage) {
		waitForClickable(driver, AdminPostAllPageUI.CHECKBOX_IN_ROW_BY_TEXT, titlePage);
		clickToElement(driver, AdminPostAllPageUI.CHECKBOX_IN_ROW_BY_TEXT, titlePage);
	}

	public void selectDropdownListByText(String textInDropdown) {
		waitForClickable(driver, AdminPostAllPageUI.SELECT_ACTION_DROPDOWN, textInDropdown);
		selectItemInDefaultDropdown(driver, AdminPostAllPageUI.SELECT_ACTION_DROPDOWN, textInDropdown);
	}

	public void clickToApplyButton() {
		waitForClickable(driver, AdminPostAllPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostAllPageUI.APPLY_BUTTON);
	}

	public boolean isMessageDisplayed(String text) {
		waitForElementVisible(driver, AdminPostAllPageUI.VERIFY_MESSAGE_WITH_ACTION, text);
		return isElementDisplayed(driver, AdminPostAllPageUI.VERIFY_MESSAGE_WITH_ACTION, text);
	}
}
