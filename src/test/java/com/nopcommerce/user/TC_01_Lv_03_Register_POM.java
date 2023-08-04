package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserRegisterPageObject;

public class TC_01_Lv_03_Register_POM {
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	String firstName, lastName, password;

	String projectPath = System.getProperty("user.dir");
	String emailAddress = "afc" + fakeNumber() + "@gmail.com";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// 1
		homePage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		password = "123456";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		// 2
		registerPage = new UserRegisterPageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01: Step 01: Click to Register link");

		homePage.clickToRegisterLink();
		System.out.println("Register_01: Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_01: Step 03: Verify message error");
		Assert.assertEquals(registerPage.getFirstNameError(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameError(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailError(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordError(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmError(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage = new UserRegisterPageObject(driver);
		System.out.println("Register_02: Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		System.out.println("Register_02: Step 02: Input wrong email");
		registerPage.inputEmailTextBox("12312323@444421@!#$@");
		System.out.println("Register_02: Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_02: Step 04: Verify message error");
		Assert.assertEquals(registerPage.getEmailError(), "Wrong email");

	}

	@Test
	public void Register_03_Success() {
		registerPage = new UserRegisterPageObject(driver);
		System.out.println("Register_03: Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		System.out.println("Register_03: Step 02: Input fields");

		registerPage.inputFirstNameTextBox(firstName);
		registerPage.inputLastNameTextBox(lastName);
		registerPage.inputEmailTextBox(emailAddress);
		registerPage.inputPasswordTextBox(password);
		registerPage.inputConfirmPasswordTextBox(password);
		System.out.println("Register_03: Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_03: Step 04: Verify message success");
		Assert.assertEquals(registerPage.getEmailSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Register_04_Existing_Email() {
		registerPage = new UserRegisterPageObject(driver);
		System.out.println("Register_04: Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		System.out.println("Register_04: Step 02: Input fields");
		registerPage.inputFirstNameTextBox(firstName);
		registerPage.inputLastNameTextBox(lastName);
		registerPage.inputEmailTextBox(emailAddress);
		registerPage.inputPasswordTextBox(password);
		registerPage.inputConfirmPasswordTextBox(password);
		System.out.println("Register_04: Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_03: Step 04: Verify message email exists");
		Assert.assertEquals(registerPage.getEmailExitingMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		registerPage = new UserRegisterPageObject(driver);
		System.out.println("Register_05: Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		System.out.println("Register_05: Step 02: Input fields");
		registerPage.inputFirstNameTextBox(firstName);
		registerPage.inputLastNameTextBox(lastName);
		registerPage.inputEmailTextBox(emailAddress);
		registerPage.inputPasswordTextBox("123");
		registerPage.inputConfirmPasswordTextBox("123");
		System.out.println("Register_05: Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_05: Step 04: Verify message password error");
		Assert.assertEquals(registerPage.getPasswordError(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		registerPage = new UserRegisterPageObject(driver);
		System.out.println("Register_06: Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		System.out.println("Register_06: Step 02: Input fields");
		registerPage.inputFirstNameTextBox(firstName);
		registerPage.inputLastNameTextBox(lastName);
		registerPage.inputEmailTextBox(emailAddress);
		registerPage.inputPasswordTextBox(password);
		registerPage.inputConfirmPasswordTextBox("1234");
		System.out.println("Register_06: Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register_06: Step 04: Verify message password do not match");
		Assert.assertEquals(registerPage.getConfirmError(), "The password and confirmation password do not match.");
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
