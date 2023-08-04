package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;

@Listeners(commons.MethodListener.class)
public class TC_01_Lv16_Page_Element_Component extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		emailAddress = "afc" + fakeNumber() + "@gmail.com";
		day = "14";
		month = "November";
		year = "1997";
		gender = "Female";
		checkboxText = "Newsletter";
	}

	@Test
	public void TC_01_Register_Account() {
		log.info("Register Account - Step 01: Click to register button");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register Account - Step 02: Select Gender radio value is: " + gender);
		registerPage.selectRadioButtonByText(driver, gender);

		log.info("Register Account - Step 03: Select Day DropdownList value is: " + day);
		registerPage.selectDropdownByNameAttribute(driver, "DateOfBirthDay", day);

		log.info("Register Account - Step 04: Select Month DropdownList value is: " + month);
		registerPage.selectDropdownByNameAttribute(driver, "DateOfBirthMonth", month);

		log.info("Register Account - Step 05: Select Year DropdownList value is: " + year);
		registerPage.selectDropdownByNameAttribute(driver, "DateOfBirthYear", year);

		log.info("Register Account - Step 06: Check Checkbox value is: " + checkboxText);
		registerPage.checkCheckBoxByText(driver, checkboxText);

		log.info("Register Account - Step 07: Input into FirstName textbox value is: " + firstName);
		registerPage.inputTextBoxByID(driver, "FirstName", firstName);

		log.info("Register Account - Step 08: Input into LastName textbox value is: " + lastName);
		registerPage.inputTextBoxByID(driver, "LastName", lastName);

		log.info("Register Account - Step 09: Input into Email textbox value is: " + emailAddress);
		registerPage.inputTextBoxByID(driver, "Email", emailAddress);

		log.info("Register Account - Step 10: Input into Password textbox value is: " + passWord);
		registerPage.inputTextBoxByID(driver, "Password", passWord);

		log.info("Register Account - Step 11: Input into Confirm Password textbox value is: " + passWord);
		registerPage.inputTextBoxByID(driver, "ConfirmPassword", passWord);

		log.info("Register Account - Step 07: Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Register Account - Step 08: Verify register message success");
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_02_Login_Page() {
		log.info("Login Account - Step 01: Click to login button");
		loginPage = homePage.clickToLoginLink();

		log.info("Login Account - Step 02: Input to email address value is: " + emailAddress);
		loginPage.inputTextBoxByID(driver, "Email", emailAddress);

		log.info("Login Account - Step 03: Input to email password value is:" + passWord);
		loginPage.inputTextBoxByID(driver, "Password", passWord);

		log.info("Login Account - Step 04: Click to login button");
		loginPage.clickToLoginButton();

		log.info("Login Account - Step 05: Verify 'My Account' text");
		Assert.assertEquals(homePage.getMyAccountText(), "My account");

		log.info("Login Account - Step 06: Click to 'My Account' text");
		customerInfo = homePage.clicktoMyAccountLink();

		log.info("Login Account - Step 07: Verify 'Customer info' text");
		Assert.assertTrue(customerInfo.isTitleDisplayed(driver));
	}
	
	@Test
	public void TC_03_Verify_Data() {
		log.info("Verify Data - Step 01: Verify 'FirstName' TextBox");
		Assert.assertEquals(customerInfo.verifyTextBoxByID(driver, "FirstName", "value"), firstName);
		
		log.info("Verify Data - Step 02: Verify 'LastName' TextBox");
		Assert.assertEquals(customerInfo.verifyTextBoxByID(driver, "LastName", "value"), lastName);
		
		log.info("Verify Data - Step 03: Verify 'EmailAddress' TextBox");
		Assert.assertEquals(customerInfo.verifyTextBoxByID(driver, "Email", "value"), emailAddress);
		
		log.info("Verify Data - Step 04: Verify 'Gender' Radio");
		Assert.assertTrue(customerInfo.verifyRadioCheckedByText(driver, gender));
		
		log.info("Verify Data - Step 05: Verify 'Day' Dropdown");
		Assert.assertEquals(customerInfo.verifyDropDownListByNameAttribute(driver, "DateOfBirthDay"), day);
		
		log.info("Verify Data - Step 06: Verify 'Month' Dropdown");
		Assert.assertEquals(customerInfo.verifyDropDownListByNameAttribute(driver, "DateOfBirthMonth"), month);
		
		log.info("Verify Data - Step 07: Verify 'Year' Dropdown");
		Assert.assertEquals(customerInfo.verifyDropDownListByNameAttribute(driver, "DateOfBirthYear"), year);
		
		log.info("Verify Data - Step 08: Verify 'Newsletter' Checkbox");
		Assert.assertFalse(customerInfo.verifyCheckBoxByText(driver, checkboxText));
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerInfo;
	String firstName, lastName, passWord, emailAddress, day, month, year, gender, checkboxText;
}
