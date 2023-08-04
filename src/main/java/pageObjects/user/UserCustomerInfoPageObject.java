package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserAddressesUI;
import pageUIs.user.UserCustomerInfoUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isTitleDisplayed(WebDriver driver) {
		waitForElementVisible(driver, UserCustomerInfoUI.HEADER);
		return isElementDisplayed(driver, UserCustomerInfoUI.HEADER);
	}

	public void selectGender() {
		waitForClickable(driver, UserCustomerInfoUI.EDIT_GENDER);
		clickToElement(driver, UserCustomerInfoUI.EDIT_GENDER);
	}

	public void editFirstName(String firstName) {
		waitForElementVisible(driver, UserCustomerInfoUI.EDIT_FIRST_NAME);
		sendKeyToElement(driver, UserCustomerInfoUI.EDIT_FIRST_NAME, firstName);
	}

	public void editLastName(String lastName) {
		waitForElementVisible(driver, UserCustomerInfoUI.EDIT_LAST_NAME);
		sendKeyToElement(driver, UserCustomerInfoUI.EDIT_LAST_NAME, lastName);
	}

	public void editDateOfBirth(String date) {
		waitForElementVisible(driver, UserCustomerInfoUI.EDIT_DAY_OF_BIRTH);
		selectItemInDefaultDropdown(driver, UserCustomerInfoUI.EDIT_DAY_OF_BIRTH, date);
	}

	public void editMonthOfBirth(String month) {
		waitForElementVisible(driver, UserCustomerInfoUI.EDIT_MONTH_OF_BIRTH);
		selectItemInDefaultDropdown(driver, UserCustomerInfoUI.EDIT_MONTH_OF_BIRTH, month);
	}

	public void editYearOfBirth(String year) {
		waitForElementVisible(driver, UserCustomerInfoUI.EDIT_YEAR_OF_BIRTH);
		selectItemInDefaultDropdown(driver, UserCustomerInfoUI.EDIT_YEAR_OF_BIRTH, year);
	}

	public void editEmail(String email) {
		waitForElementVisible(driver, UserCustomerInfoUI.EDIT_EMAIL);
		sendKeyToElement(driver, UserCustomerInfoUI.EDIT_EMAIL, email);
	}

	public void editCompanyName(String companyName) {
		waitForElementVisible(driver, UserCustomerInfoUI.EDIT_COMPANY_NAME);
		sendKeyToElement(driver, UserCustomerInfoUI.EDIT_COMPANY_NAME, companyName);
	}
	public void clickToSaveInfoButton() {
		waitForClickable(driver, UserCustomerInfoUI.SAVE_INFO_BUTTON);
		clickToElement(driver, UserCustomerInfoUI.SAVE_INFO_BUTTON);
	}
	public void updateCustomerInfomation(String firstName, String lastName, String day, String month, String year, String email, String companyName) {
		selectGender();
		editFirstName(firstName);
		editLastName(lastName);
		editDateOfBirth(day);
		editMonthOfBirth(month);
		editYearOfBirth(year);
		editEmail(email);
		editCompanyName(companyName);
		clickToSaveInfoButton();
	}








	
}
