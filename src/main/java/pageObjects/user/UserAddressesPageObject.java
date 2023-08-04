package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.UserAddressesUI;

public class UserAddressesPageObject extends BasePage {
	WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddAddressButton() {
		waitForClickable(driver, UserAddressesUI.ADD_ADDRESS_BUTTON);
		clickToElement(driver, UserAddressesUI.ADD_ADDRESS_BUTTON);
	}

	public void inputAddressFirstName(String firstName) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_FIRST_NAME);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_FIRST_NAME, firstName);
	}

	public void inputAddressLastName(String lastName) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_LAST_NAME);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_LAST_NAME, lastName);
	}

	public void inputAddressEmail(String email) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_EMAIL);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_EMAIL, email);
	}

	public void inputAddressCompanyName(String companyName) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_COMPANY_NAME);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_COMPANY_NAME, companyName);
	}

	public void inputAddressCountry(String country) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_COUNTRY);
		selectItemInDefaultDropdown(driver, UserAddressesUI.ADDRESS_COUNTRY, country);
	}

	public void inputAddressProvince(String province) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_PROVINCE);
		selectItemInDefaultDropdown(driver, UserAddressesUI.ADDRESS_PROVINCE, province);
	}

	public void inputAddressCity(String city) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_CITY);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_CITY, city);
	}

	public void inputAddressAddress1(String address1) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_ADDRESS1);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_ADDRESS1, address1);
	}

	public void inputAddressAddress2(String address2) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_ADDRESS2);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_ADDRESS2, address2);
	}

	public void inputAddressPostalCode(String postalCode) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_POSTAL_CODE);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_POSTAL_CODE, postalCode);
	}

	public void inputAddressPhoneNumber(String phoneNumber) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_PHONEUMBER);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_PHONEUMBER, phoneNumber);
	}

	public void inputAddressFaxNumber(String faxNumber) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS_FAX_NUMBER);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS_FAX_NUMBER, faxNumber);
	}

	public void clickToSaveAddressButton() {
		waitForClickable(driver, UserAddressesUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, UserAddressesUI.ADDRESS_SAVE_BUTTON);
	}

	public void AddNewAddress(String firstName, String lastName, String email, String companyName, String country, String province, String city, String address1, String address2, String postalCode, String phoneNumber, String faxNumber) {
		clickToAddAddressButton();
		inputAddressFirstName(firstName);
		inputAddressLastName(lastName);
		inputAddressEmail(email);
		inputAddressCompanyName(companyName);
		inputAddressCountry(country);
		inputAddressCity(city);
		inputAddressProvince(province);
		inputAddressAddress1(address1);
		inputAddressAddress2(address2);
		inputAddressPostalCode(postalCode);
		inputAddressPhoneNumber(phoneNumber);
		inputAddressFaxNumber(faxNumber);
		clickToSaveAddressButton();
	}
}
