package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserDesktopUI;

public class UserDeskTopPageObject extends BasePage{
	WebDriver driver;
	public UserDeskTopPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserDetailProductPageObject selectDesktop(String desktopTitle) {
		waitForClickable(driver, BasePage.locator_1_Parameter(UserDesktopUI.DESK_TOP_TITLE, desktopTitle));
		clickToElement(driver, BasePage.locator_1_Parameter(UserDesktopUI.DESK_TOP_TITLE, desktopTitle));
		return PageGeneratorManager.getDetailProductPage(driver);
	}
	
	
}
