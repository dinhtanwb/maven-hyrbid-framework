package com.jQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.jQuery.HomePageObjectJQuery;

public class TC_01_Lv09_DataGrid_DataTable2 extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	HomePageObjectJQuery homePage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultipleBrowserJQuery(browserName);
		homePage = PageGeneratorManager.getHomePageJQuery(driver);
	}

	@Test
	public void Pagination_01() {
		homePage.sendKeyToDynamicTexboxByColumnTextAtRowNumber("Company", "1", "Boston");
		homePage.sendKeyToDynamicTexboxByColumnTextAtRowNumber("Contact Person", "2", "Dinh Tan");
		homePage.sendKeyToDynamicTexboxByColumnTextAtRowNumber("Order Placed", "3", "223");
		
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Germany");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Hong Kong");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "3", "Malaysia");
		
		homePage.checkCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.checkCheckboxByColumnNameAtRowNumber("NPO?", "2");
		homePage.checkCheckboxByColumnNameAtRowNumber("NPO?", "3");
		
		homePage.clickToIconByRowIndexAtTitle("1", "Remove Current Row");
		homePage.clickToIconByRowIndexAtTitle("1", "Remove Current Row");
		homePage.clickToIconByRowIndexAtTitle("1", "Remove Current Row");
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
