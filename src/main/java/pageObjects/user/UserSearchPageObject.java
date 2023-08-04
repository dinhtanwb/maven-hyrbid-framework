package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.user.UserSearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}

	public String getTextErrorMessage() {
		return getElementText(driver, UserSearchPageUI.SEARCH_ERROR_MESSAGE);
	}

	public void inputSearchTextBox(String valueText) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_TEXT_BOX);
		sendKeyToElement(driver, UserSearchPageUI.SEARCH_TEXT_BOX, valueText);
	}

	public String getTextNoResultMessage() {
		return getElementText(driver, UserSearchPageUI.SEARCH_NO_RESULT);
	}

	public boolean getListProductTitle(String titleText) {
		boolean isTitleDisplay = false;
		waitForAllElementVisible(driver, UserSearchPageUI.LIST_ITEM_TITLE);
		List<WebElement> items = getListWebElements(driver, UserSearchPageUI.LIST_ITEM_TITLE);
		for (WebElement item : items) {
			isTitleDisplay = item.getText().contains(titleText);
		}
		return isTitleDisplay;
	}
	public void clickToSearchAdvanceCheckbox() {
		
		checkToDefaultCheckboxRadio(driver, UserSearchPageUI.SEARCH_ADVANCE_CHECKBOX);
		
	}
	public void selectCategoryDropdown(String valueCategory) {
		selectItemInDefaultDropdown(driver, UserSearchPageUI.CATEGORY_DROPDOWN, valueCategory);
	}
	public void searchWithParentCategory(String valueCategory) {
		clickToSearchAdvanceCheckbox();
		selectCategoryDropdown(valueCategory);
	}
	public void clickToSubCategoryCheckBox() {
		checkToDefaultCheckboxRadio(driver, UserSearchPageUI.SUB_CATEGORY_CHECKBOX);
	}
	public void selectManufacturerDropdown(String valueCategory) {
		selectItemInDefaultDropdown(driver, UserSearchPageUI.MANUFACTUTRER_DROPDOWN, valueCategory);
	}
	
}
