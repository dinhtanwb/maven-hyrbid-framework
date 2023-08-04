package com.jQuery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.jQuery.HomePageObjectJQuery;

public class TC_01_Lv10_Upload_Multiple_Files extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObjectJQuery homePage;
	String csharpFileName = "Csharp.jpg";
	String javaFileName = "Java.png";
	String rubyFileName = "Ruby.jpg";
	String pythonFileName = "Python.jpg";
	String[] multipleFileName = { csharpFileName, javaFileName, rubyFileName, pythonFileName };

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowser(browserName);
		homePage = PageGeneratorManager.getHomePageJQuery(driver);

	}

	@Test
	public void Upload_Per_File() {
		homePage.uploadMultipleFile(driver, csharpFileName);
		homePage.uploadMultipleFile(driver, javaFileName);
		Assert.assertTrue(homePage.isDisplayLoadedFileByText(driver, csharpFileName));
		Assert.assertTrue(homePage.isDisplayLoadedFileByText(driver, javaFileName));
		homePage.clickToStartButton(driver);
		Assert.assertTrue(homePage.uploadFileSuccess(csharpFileName));
		Assert.assertTrue(homePage.uploadFileSuccess(javaFileName));
	}

	@Test
	public void Upload_Per_Multiple_File() {
		homePage.refreshBrowser(driver);
		homePage.uploadMultipleFile(driver, multipleFileName);
		Assert.assertTrue(homePage.isDisplayLoadedFileByText(driver, csharpFileName));
		Assert.assertTrue(homePage.isDisplayLoadedFileByText(driver, javaFileName));
		Assert.assertTrue(homePage.isDisplayLoadedFileByText(driver, rubyFileName));
		Assert.assertTrue(homePage.isDisplayLoadedFileByText(driver, pythonFileName));
		homePage.clickToStartButton(driver);
		Assert.assertTrue(homePage.uploadFileSuccess(csharpFileName));
		Assert.assertTrue(homePage.uploadFileSuccess(javaFileName));
		Assert.assertTrue(homePage.uploadFileSuccess(rubyFileName));
		Assert.assertTrue(homePage.uploadFileSuccess(pythonFileName));
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
