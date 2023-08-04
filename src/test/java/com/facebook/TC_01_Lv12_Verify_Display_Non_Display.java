package com.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorManagerFacebook;

public class TC_01_Lv12_Verify_Display_Non_Display extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	LoginPageObject loginPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		loginPage = PageGeneratorManagerFacebook.getLoginPage(driver);
	}
	@Test
	public void TC_01_Verify_Element_Display() {
		// Verify element visible/display
		loginPage.clickToLoginButton();
		loginPage.sendkeyToEmailTextBox("automation@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isDisplayConfirmEmailTextBox("Re-enter email address"));
	}
	@Test
	public void TC_02_Verify_Element_UnDisplay_But_Visible_In_DOM() {
		// Verify element non-display & in DOM
		loginPage.sendkeyToEmailTextBox("");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isTextBoxUnDisplay("Re-enter email address"));
	}
	@Test
	public void TC_03_Verify_Element_UnDisplay_In_DOM() {
		// Verify element non-display in DOM
		loginPage.closeTheForm();
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isTextBoxUnDisplay("Re-enter email address"));
	}
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
