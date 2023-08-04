package pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commons.BasePageFactory;
import pageUIs.user.UserHomePageUI;

public class HomePageFactory extends BasePageFactory{
	WebDriver driver;
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	//define UI
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	
	
	//define action
	public void clickToRegisterLink() {
		waitForClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}
	public void clickToLoginLink() {
		waitForClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}
	public String getMyAccountText() {
		waitForElementVisible(driver, myAccountLink);
		return getElementText(driver, myAccountLink);
	}
	public void clickToLogoutLink() {
		waitForClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}
}
