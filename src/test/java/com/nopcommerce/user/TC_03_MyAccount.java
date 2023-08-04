package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserDeskTopPageObject;
import pageObjects.user.UserDetailProductPageObject;
import pageObjects.user.UserDetailReviewPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageUIs.user.UserAddressesUI;
import pageUIs.user.UserChangePasswordUI;
import pageUIs.user.UserCustomerInfoUI;

public class TC_03_MyAccount extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfo;
	UserAddressesPageObject addressPage;
	UserChangePasswordPageObject changePasswordPage;
	UserDeskTopPageObject deskTopPage;
	UserDetailProductPageObject detailProductPage;
	UserDetailReviewPageObject detailReviewPage;
	private String passWord = "123456";

	// Customer information
	private String firstName = "Automation";
	private String lastName = "FC";
	private String day = "22";
	private String month = "January";
	private String year = "2023";
	private String companyName = "Automation FC";
	private String email = "automationfc" + fakeNumber() + ".vn@gmail.com";

	private String countryName = "United States";
	private String city = "HCM City";
	private String address1 = "123/04 Le Lai";
	private String address2 = "234/05 Hai Phong";
	private String postalCode = "550000";
	private String phoneNumber = "0123456789";
	private String faxNumber = "0987654321";
	private String province = "Hawaii";
	private String newPassword = "123456788";
	private String newEmail = "automationfc" + fakeNumber() + "@gmail.com";
	private String emailAddress = "afc" + fakeNumber() + "@gmail.com";
	private String deskTopTitle = "Build your own computer";
	private String titleReview = "This is title review";
	private String contentReview = "Description here";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = openMultipleBrowser(browserName);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		emailAddress = "afc" + fakeNumber() + "@gmail.com";

		registerPage = homePage.clickToRegisterLink();

		// pre-condition
		homePage = registerPage.registerAccount(firstName, lastName, emailAddress, passWord);
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");

		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.loginAsUser(emailAddress, passWord);
		customerInfo = homePage.clicktoMyAccountLink();
		Assert.assertTrue(customerInfo.isTitleDisplayed(driver));
	}

	@Test
	public void TC_01_Customer_Info() {
		customerInfo.updateCustomerInfomation(firstName, lastName, day, month, year, newEmail, companyName);
		Assert.assertEquals(customerInfo.getElementText(driver, UserCustomerInfoUI.SAVE_INFO_SUCCESS_MESSAGE), "The customer info has been updated successfully.");
	}

	@Test
	public void TC_02_Add_Customer_Address() {
		addressPage = customerInfo.openAddressLink(driver);
		Assert.assertTrue(addressPage.isElementDisplayed(driver, UserAddressesUI.HEADER_ADDRESSES));
		addressPage.AddNewAddress(firstName, lastName, email, companyName, countryName, province, city, address1, address2, postalCode, phoneNumber, faxNumber);

		// verify
		Assert.assertTrue(addressPage.isElementDisplayed(driver, UserAddressesUI.VERIFY_ADD_ADDRESS_SUCCESS_MESSAGE));

		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_FULL_NAME), firstName + " " + lastName);
		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_EMAIL), "Email: " + email);
		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_COMPANY), companyName);
		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_COUNTRY), countryName);
		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_CITY_POSTALCODE), city + ", " + province + ", " + postalCode);
		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_ADDRESS1), address1);
		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_ADDRESS2), address2);
		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_PHONE_NUMBER), "Phone number: " + phoneNumber);
		Assert.assertEquals(addressPage.getElementText(driver, UserAddressesUI.VERIFY_FAX_NUMBER), "Fax number: " + faxNumber);

	}

	@Test
	public void TC_03_Change_Password() {
		changePasswordPage = addressPage.openChangePasswordLink(driver);
		changePasswordPage.changePassword(passWord, newPassword);

		Assert.assertEquals(changePasswordPage.getElementText(driver, UserChangePasswordUI.CHANGE_PASSWORD_SUCCESS_MESSAGE), "Password was changed");
		changePasswordPage.clickToElement(driver, UserChangePasswordUI.CHANGE_PASSWORD_SUCCESS_MESSAGE_BUTTON);
		changePasswordPage.waitForElementInvisible(driver, UserChangePasswordUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);

		homePage = changePasswordPage.clickToLogoutLink();
		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.loginAsUser(newEmail, newPassword);
		Assert.assertEquals(homePage.getMyAccountText(), "My account");
		
		

	}

	@Test
	public void TC_04_Review_Product() {
		deskTopPage = homePage.openDesktopProduct(driver);
		detailProductPage = deskTopPage.selectDesktop(deskTopTitle);
		detailReviewPage = detailProductPage.addYourReview();
		Assert.assertTrue(detailReviewPage.isDisplayHeader(deskTopTitle));
		detailReviewPage.addYourReview(titleReview, contentReview);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
