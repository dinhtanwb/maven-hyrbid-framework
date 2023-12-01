package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.EBT.FEHomePageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.jQuery.HomePageObjectJQuery;
import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserDeskTopPageObject;
import pageObjects.user.UserDetailProductPageObject;
import pageObjects.user.UserDetailReviewPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserNoteBookPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserSearchPageObject;

public class PageGeneratorManager {
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}
	public static UserAddressesPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static UserOrderPageObject getOrderPage(WebDriver driver) {
		return new UserOrderPageObject(driver);
	}
	public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static UserDeskTopPageObject getDeskTopPage(WebDriver driver) {
		return new UserDeskTopPageObject(driver);
	}
	public static UserDetailProductPageObject getDetailProductPage(WebDriver driver) {
		return new UserDetailProductPageObject(driver);
	}
	public static UserDetailReviewPageObject getDetailReviewPage(WebDriver driver) {
		return new UserDetailReviewPageObject(driver);
	}
	public static UserSearchPageObject getSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
	public static UserNoteBookPageObject getNoteBookPage(WebDriver driver) {
		return new UserNoteBookPageObject(driver);
	}
	public static HomePageObjectJQuery getHomePageJQuery(WebDriver driver) {
		return new HomePageObjectJQuery(driver);
	}
	public static FEHomePageObject getFEHomePageObject(WebDriver driver) {
		return new FEHomePageObject(driver);
	}

}
