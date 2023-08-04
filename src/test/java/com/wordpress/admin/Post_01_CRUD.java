package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashBoardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostAllPO;
import pageObjects.wordpress.admin.PageGeneratorManager;
import pageObjects.wordpress.endUser.UserHomePO;
import pageObjects.wordpress.endUser.UserSearchProductPO;

@Listeners(commons.MethodListener.class)
public class Post_01_CRUD extends BaseTest {
	private String adminUserName = "tnpromax";
	private String adminPassword = "*v^w#*3vEWsh&gdsLw";
	private String currentURL;
	private int fakeNumber = fakeNumber();
	private String titlePage = "Selenium Page Title " + fakeNumber;
	private String bodyPage = "Selenium Page Body " + fakeNumber;
	private String author = "tnpromax";
	private String categories = "Uncategorized";
	private String urlAdmin, urlUser;
	private String currentDay = getToday();
	private String editTitle = "Edit " + titlePage;
	private String editBody = "Edit " + bodyPage;

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String urlUser) {
		this.urlAdmin = urlAdmin;
		this.urlUser = urlUser;
		driver = openMultipleBrowser(browserName, this.urlAdmin);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-Condition - Step 01: Enter to Username TextBox value: " + adminUserName);
		adminLoginPage.enterToUserNameTextBox(adminUserName);

		log.info("Pre-Condition - Step 02: Enter to Password TextBox value: " + adminPassword);
		adminLoginPage.enterToPasswordTextBox(adminPassword);

		log.info("Pre-Condition - Step 03: Click to login button");
		adminDashBoardPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_New_Post - Step 01: Click to Posts menu sidebar");
		adminPostAllPage = adminDashBoardPage.clickToPostMenuSideBar();
		currentURL = adminPostAllPage.getcurrentURL(driver);

		log.info("Create_New_Post - Step 02: Click to Add New button");
		adminPostAddNewPage = adminPostAllPage.clickToAddNewButton();

		log.info("Create_New_Post - Step 03: Enter New Post title value: " + titlePage);
		adminPostAddNewPage.enterToTitlePage(titlePage);

		log.info("Create_New_Post - Step 04: Enter New Post body value: " + bodyPage);
		adminPostAddNewPage.enterToBodyPage(bodyPage);

		log.info("Create_New_Post - Step 05: Click to Publish button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create_New_Post - Step 06: Click to Re-publish button");
		adminPostAddNewPage.clickToRePublishButton();

		log.info("Create_New_Post - Step 07: Verify Published message displayed");
		verifyTrue(adminPostAddNewPage.isPublisheOrUpdatesMessageDisplayed("Post published"));

	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01: Open Search Post page");
		adminPostAllPage = adminPostAddNewPage.openSearchPostPageUrl(currentURL);

		log.info("Search_Post - Step 02: Enter to Search TextBox value: " + titlePage);
		adminPostAllPage.enterToSearchTextBox(titlePage);

		log.info("Search_Post - Step 03: Click to Search Posts button");
		adminPostAllPage.clickToSearchPostsButton();

		log.info("Search_Post - Step 04: Verify Author displayed is: " + author);
		verifyEquals(adminPostAllPage.isDisplayTextByNameColumn("Author"), author);

		log.info("Search_Post - Step 05: Verify Categories displayed are: " + categories);
		verifyEquals(adminPostAllPage.isDisplayTextByNameColumn("Categories"), categories);
	}

	@Test
	public void Post_03_View_Post() {
		log.info("View_Post - Step 01: Open User page site");
		userHome = adminPostAllPage.openUserSite(driver, this.urlUser);

		log.info("View_Post - Step 02: Verify Post Title Displayed: " + titlePage);
		verifyTrue(userHome.isPostInforDisplayWithTitle(titlePage));

		log.info("View_Post - Step 03: Verify Post Date Time Displayed: " + currentDay);
		verifyTrue(userHome.isPostInforDisplayWithDateTime(titlePage, currentDay));

		log.info("View_Post - Step 04: Verify Post Body : " + bodyPage);
		verifyTrue(userHome.isPostInforDisplayWithBody(titlePage, bodyPage));

		log.info("View_Post - Step 05: Verify Post By Author Displayed: " + author);
		verifyTrue(userHome.isPostInforDisplayWithAuthor(titlePage, author));

		log.info("View_Post - Step 06: Click to Title Post & navigate to detail post value: " + titlePage);
		userHome.clickToPostTitleByText(titlePage);

		log.info("View_Post - Step 07: Verify Detail Post Title Displayed: " + titlePage);
		verifyTrue(userHome.isPostDetailInforDisplayWithTitle(titlePage));

		log.info("View_Post - Step 08: Verify Detail Post Date Time Displayed: " + currentDay);
		verifyTrue(userHome.isPostDetailInforDisplayWithDateTime(titlePage, currentDay));

		log.info("View_Post - Step 09: Verify Detail Post Body: " + bodyPage);
		verifyTrue(userHome.isPostDetailInforDisplayWithBody(titlePage, bodyPage));

		log.info("View_Post - Step 10: Verify Detail Post By Author Displayed: " + author);
		verifyTrue(userHome.isPostDetailInforDisplayWithAuthor(titlePage, author));

	}

	@Test
	public void Post_04_Edit_Post() {
		log.info("Edit_Post - Step 01: Open Admin page site");
		adminLoginPage = userHome.openToAdminSiteUrl(driver, this.urlAdmin);

		log.info("Pre-Condition - Step 01: Enter to Username TextBox value: " + adminUserName);
		adminLoginPage.enterToUserNameTextBox(adminUserName);

		log.info("Pre-Condition - Step 02: Enter to Password TextBox value: " + adminPassword);
		adminLoginPage.enterToPasswordTextBox(adminPassword);

		log.info("Pre-Condition - Step 03: Click to login button");
		adminDashBoardPage = adminLoginPage.clickToLoginButton();

		log.info("Edit_Post - Step 02: Click to Posts Menu");
		adminPostAllPage = adminDashBoardPage.clickToPostMenuSideBar();

		log.info("Edit_Post - Step 03: Select Post Title in row by text");
		adminPostAddNewPage = adminPostAllPage.clickToPostTitleInRowByText(titlePage);

		log.info("Edit_Post - Step 04: Edit page title value is: " + editTitle);
		adminPostAddNewPage.enterToTitlePage(editTitle);
		
		log.info("Edit_Post - Step 05: Edit page body value is: " + editBody);
		adminPostAddNewPage.enterToBodyPage(editBody);
		
		log.info("Edit_Post - Step 06: Click to update button");
		adminPostAddNewPage.clickToUpdateButton();
		
		log.info("Edit_Post - Step 07: Verify update success message");
		verifyTrue(adminPostAddNewPage.isPublisheOrUpdatesMessageDisplayed("Post updated"));
		
		log.info("Edit_Post - Step 08: Navigate to Post Menu");
		adminPostAllPage = adminPostAddNewPage.openSearchPostPageUrl(currentURL);

		log.info("Edit_Post - Step 09: Enter to Search TextBox value: " + editTitle);
		adminPostAllPage.enterToSearchTextBox(editTitle);

		log.info("Edit_Post - Step 10: Click to Search Posts button");
		adminPostAllPage.clickToSearchPostsButton();

		log.info("Edit_Post - Step 11: Verify Author displayed is: " + author);
		verifyEquals(adminPostAllPage.isDisplayTextByNameColumn("Author"), author);

		log.info("Edit_Post - Step 12: Verify Categories displayed are: " + categories);
		verifyEquals(adminPostAllPage.isDisplayTextByNameColumn("Categories"), categories);

		log.info("Edit_Post - Step 13: Open User page site");
		userHome = adminPostAllPage.openUserSite(driver, this.urlUser);

		log.info("Edit_Post - Step 14: Verify Post Title Displayed: " + editTitle);
		verifyTrue(userHome.isPostInforDisplayWithTitle(editTitle));

		log.info("Edit_Post - Step 15: Verify Post Date Time Displayed: " + currentDay);
		verifyTrue(userHome.isPostInforDisplayWithDateTime(editTitle, currentDay));

		log.info("Edit_Post - Step 16: Verify Post Body : " + editBody);
		verifyTrue(userHome.isPostInforDisplayWithBody(editTitle, editBody));

		log.info("Edit_Post - Step 17: Verify Post By Author Displayed: " + author);
		verifyTrue(userHome.isPostInforDisplayWithAuthor(editTitle, author));

		log.info("Edit_Post - Step 18: Click to Title Post & navigate to detail post value: " + editTitle);
		userHome.clickToPostTitleByText(editTitle);

		log.info("Edit_Post - Step 19: Verify Detail Post Title Displayed: " + editTitle);
		verifyTrue(userHome.isPostDetailInforDisplayWithTitle(editTitle));

		log.info("Edit_Post - Step 20: Verify Detail Post Date Time Displayed: " + currentDay);
		verifyTrue(userHome.isPostDetailInforDisplayWithDateTime(editTitle, currentDay));

		log.info("Edit_Post - Step 21: Verify Detail Post Body: " + editBody);
		verifyTrue(userHome.isPostDetailInforDisplayWithBody(editTitle, editBody));

		log.info("Edit_Post - Step 22: Verify Detail Post By Author Displayed: " + author);
		verifyTrue(userHome.isPostDetailInforDisplayWithAuthor(editTitle, author));

	}

	@Test
	public void Post_05_Delete_Post() {
		log.info("Delete_Post - Step 01: Open Admin page site");
		adminLoginPage = userHome.openToAdminSiteUrl(driver, this.urlAdmin);
		
		log.info("Delete_Post - Step 02: Enter to Username TextBox value: " + adminUserName);
		adminLoginPage.enterToUserNameTextBox(adminUserName);

		log.info("Delete_Post - Step 03: Enter to Password TextBox value: " + adminPassword);
		adminLoginPage.enterToPasswordTextBox(adminPassword);

		log.info("Delete_Post - Step 04: Click to login button");
		adminDashBoardPage = adminLoginPage.clickToLoginButton();

		log.info("Delete_Post - Step 05: Click to Posts Menu");
		adminPostAllPage = adminDashBoardPage.clickToPostMenuSideBar();
		
		log.info("Delete_Post - Step 06: Select Posts By Title value: " + editTitle);
		adminPostAllPage.selectPostInRowByText(editTitle);
		
		log.info("Delete_Post - Step 07: Select Dropdown list action by Text: Move to Trash" );
		adminPostAllPage.selectDropdownListByText("Move to Trash");
		
		log.info("Delete_Post - Step 08: Click to Apply button");
		adminPostAllPage.clickToApplyButton();
		
		log.info("Delete_Post - Step 09: Verify 'post moved to the Trash' message displayed");
		verifyTrue(adminPostAllPage.isMessageDisplayed("post moved to the Trash"));
		
		log.info("Delete_Post - Step 10: Open User page site");
		userHome = adminPostAllPage.openUserSite(driver, this.urlUser);
		
		log.info("Delete_Post - Step 11: Enter to title page edited into Search products value: " + editTitle);
		userHome.enterToSearchProductByText(editTitle);
		
		log.info("Delete_Post - Step 12: Click to search button");
		userSearchProduct = userHome.clickToSearchButton();
		
		log.info("Delete_Post - Step 13: Verify user search result displayed value: ");
		verifyTrue(userSearchProduct.isSearchNoProductMessageDisplayed());
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashBoardPO adminDashBoardPage;
	AdminPostAllPO adminPostAllPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHome;
	UserSearchProductPO userSearchProduct;
	String projectPath = System.getProperty("user.dir");

}
