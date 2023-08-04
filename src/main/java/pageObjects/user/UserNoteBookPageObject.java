package pageObjects.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.user.UserNoteBookPageUI;

public class UserNoteBookPageObject extends BasePage {
	WebDriver driver;

	public UserNoteBookPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayHeader() {
		waitForElementVisible(driver, UserNoteBookPageUI.HEADER_PAGE);
		return isElementDisplayed(driver, UserNoteBookPageUI.HEADER_PAGE);
	}

	public void clickToSortDropdownByText(String string) {
		waitForClickable(driver, UserNoteBookPageUI.SORT_BY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserNoteBookPageUI.SORT_BY_DROPDOWN, string);

	}

	public boolean isItemSortingByASC() {
		List<String> listProductUI = new ArrayList<String>();

		List<WebElement> items = getListWebElements(driver, UserNoteBookPageUI.LIST_PRODUCT_ITEM);

		for (WebElement item : items) {
			listProductUI.add(item.getText());
		}

		List<String> listProductCopy = new ArrayList<String>();

		for (String item : listProductUI) {
			listProductCopy.add(item);
		}

		Collections.sort(listProductCopy);

		return listProductUI.equals(listProductCopy);

	}

	public boolean isItemSortingByDESC() {
		List<String> listProductUI = new ArrayList<String>();

		List<WebElement> items = getListWebElements(driver, UserNoteBookPageUI.LIST_PRODUCT_ITEM);

		for (WebElement item : items) {
			listProductUI.add(item.getText());
		}
		List<String> listProductCopy = new ArrayList<String>();

		for (String item : listProductUI) {
			listProductCopy.add(item);
		}

		Collections.sort(listProductCopy);
		Collections.reverse(listProductCopy);
		return listProductUI.equals(listProductCopy);

	}
}