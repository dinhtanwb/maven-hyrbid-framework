package com.jQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.jQuery.HomePageObjectJQuery;

public class TC_01_Lv09_DataGrid_DataTable extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObjectJQuery homePage;
	List<String> actualCountryData, expectedCountryData;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowserJQuery(browserName);
		homePage = PageGeneratorManager.getHomePageJQuery(driver);
	}

	@Test
	public void Pagination_01() {
		homePage.selectPaginationByText("10");
		
		homePage.selectPaginationByText("8");
		
		homePage.selectPaginationByText("23");
		
		homePage.selectPaginationByText("16");		
	}

	@Test
	public void DataTable_getAllRowInAllPage() {
		actualCountryData = homePage.getAllRowinAllPage();
		Assert.assertEquals(actualCountryData, expectedCountryData);
		
	}
	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
