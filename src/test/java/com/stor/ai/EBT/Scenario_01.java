package com.stor.ai.EBT;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.EBT.FEHomePageObject;

@Listeners(commons.MethodListener.class)
public class Scenario_01 extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		feHomePage = PageGeneratorManager.getFEHomePageObject(driver);
		
		emailAddress = "qa-vn-ecom-01@stor.ai";
		userName =  "qa-vn-ecom-01";
		passWord = "Abcd1234";
	}

	@Test
	public void TC_01_Login_Your_Account() {
		log.info("Login Account - Step 01: Click to login button");
		feHomePage.loadDialogSuccess();
		
		log.info("Login Account - Step 01: Click to login button");
		feHomePage.clickToLoginButton();

		log.info("Login Account - Step 02: Input email address value: " + emailAddress);
		feHomePage.inputEmailAddressTextBox(emailAddress);

		log.info("Login Account - Step 03: Input password value: " + passWord);
		feHomePage.inputPassWordTextBox(passWord);

		log.info("Login Account - Step 04: Click to login button");
		feHomePage.clickToSignInButton();

		log.info("Login Account - Step 05: Verify login successful with value: " + emailAddress);
		Assert.assertEquals(feHomePage.getUsernameInLink(), userName);
	}

//	@Test
//	public void TC_02_Login_Page() {
//		log.info("Login Account - Step 01: Click to login button");
//		loginPage = homePage.clickToLoginLink();
//
//		log.info("Login Account - Step 02: Input to email address value is: " + emailAddress);
//		loginPage.inputTextBoxByID(driver, "Email", emailAddress);
//
//		log.info("Login Account - Step 03: Input to email password value is:" + passWord);
//		loginPage.inputTextBoxByID(driver, "Password", passWord);
//
//		log.info("Login Account - Step 04: Click to login button");
//		loginPage.clickToLoginButton();
//
//		log.info("Login Account - Step 05: Verify 'My Account' text");
//		Assert.assertEquals(homePage.getMyAccountText(), "My account");
//
//		log.info("Login Account - Step 06: Click to 'My Account' text");
//		customerInfo = homePage.clicktoMyAccountLink();
//
//		log.info("Login Account - Step 07: Verify 'Customer info' text");
//		Assert.assertTrue(customerInfo.isTitleDisplayed(driver));
//	}
//	
//	@Test
//	public void TC_03_Verify_Data() {
//		log.info("Verify Data - Step 01: Verify 'FirstName' TextBox");
//		Assert.assertEquals(customerInfo.verifyTextBoxByID(driver, "FirstName", "value"), firstName);
//		
//		log.info("Verify Data - Step 02: Verify 'LastName' TextBox");
//		Assert.assertEquals(customerInfo.verifyTextBoxByID(driver, "LastName", "value"), lastName);
//		
//		log.info("Verify Data - Step 03: Verify 'EmailAddress' TextBox");
//		Assert.assertEquals(customerInfo.verifyTextBoxByID(driver, "Email", "value"), emailAddress);
//		
//		log.info("Verify Data - Step 04: Verify 'Gender' Radio");
//		Assert.assertTrue(customerInfo.verifyRadioCheckedByText(driver, gender));
//		
//		log.info("Verify Data - Step 05: Verify 'Day' Dropdown");
//		Assert.assertEquals(customerInfo.verifyDropDownListByNameAttribute(driver, "DateOfBirthDay"), day);
//		
//		log.info("Verify Data - Step 06: Verify 'Month' Dropdown");
//		Assert.assertEquals(customerInfo.verifyDropDownListByNameAttribute(driver, "DateOfBirthMonth"), month);
//		
//		log.info("Verify Data - Step 07: Verify 'Year' Dropdown");
//		Assert.assertEquals(customerInfo.verifyDropDownListByNameAttribute(driver, "DateOfBirthYear"), year);
//		
//		log.info("Verify Data - Step 08: Verify 'Newsletter' Checkbox");
//		Assert.assertFalse(customerInfo.verifyCheckBoxByText(driver, checkboxText));
//	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	FEHomePageObject feHomePage;
	String passWord, emailAddress,userName;
}
