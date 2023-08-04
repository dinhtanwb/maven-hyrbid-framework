package pageObjects.wordpress.endUser;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.endUser.UserSearchProductUI;

public class UserSearchProductPO extends BasePage{
 private WebDriver driver;

public UserSearchProductPO(WebDriver driver) {
	this.driver = driver;
}

public boolean isSearchNoProductMessageDisplayed() {
	waitForElementVisible(driver, UserSearchProductUI.NO_PRODUCTS_MESSAGE);
	return isElementDisplayed(driver, UserSearchProductUI.NO_PRODUCTS_MESSAGE);
}
 
}
