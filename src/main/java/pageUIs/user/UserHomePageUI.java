package pageUIs.user;

import org.openqa.selenium.WebDriver;

public class UserHomePageUI {
	WebDriver driver;

	public UserHomePageUI(WebDriver driver) {

		this.driver = driver;
	}

	public static final String REGISTER_LINK = "css=a[class='ico-register']";
	public static final String LOGIN_LINK =  "xpath=//a[@class='ico-login']";
	public static final String MYACCOUNT_LINK = "css=a[class='ico-account']";
	public static final String LOGOUT_LINK = "css=a[class='ico-logout']";
}
