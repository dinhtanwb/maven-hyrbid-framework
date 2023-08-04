package pageObjects.saucelabs;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginHomePO getLoginHomePO(WebDriver driver) {
		return new LoginHomePO(driver);
	}
	
	public static HomePO getHomePO(WebDriver driver) {
		return new HomePO(driver);
	}
}
