package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.AdminDashBoardPageUI;

public class AdminDashboardPageObject extends BasePage{
	private WebDriver driver;
	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDisplayHeader() {
		waitForElementVisible(driver, AdminDashBoardPageUI.HEADER_DASHBOARD);
		return isElementDisplayed(driver,  AdminDashBoardPageUI.HEADER_DASHBOARD);
	}

}
