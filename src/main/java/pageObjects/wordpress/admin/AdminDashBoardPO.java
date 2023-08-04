package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminDashBoardPageUI;

public class AdminDashBoardPO extends BasePage{
	private WebDriver driver;

	public AdminDashBoardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAllPO clickToPostMenuSideBar() {
		waitForClickable(driver, AdminDashBoardPageUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashBoardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostAllPage(driver);
		
	}
	
}
