package pageObjects.wordpress.endUser;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserHomePO getUserHome(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserSearchProductPO getUserSearchProduct(WebDriver driver) {
		return new UserSearchProductPO(driver);
	}
}
