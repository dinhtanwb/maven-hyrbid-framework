package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

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
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}

	public static AdminPostAllPO getAdminPostAllPage(WebDriver driver) {
		return new AdminPostAllPO(driver);
	}
	public static AdminPostAddNewPO getAdminPostNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);
	}
	public static AdminDashBoardPO getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPO(driver);
	}
}
