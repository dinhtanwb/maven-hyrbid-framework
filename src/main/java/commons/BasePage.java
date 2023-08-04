package commons;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.user.UserAddressesPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserDeskTopPageObject;
import pageObjects.user.UserNoteBookPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserSearchPageObject;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.endUser.UserHomePO;
import pageUIs.jQuery.HomePageJQueryUI;
import pageUIs.user.BaseNopCommerceUI;
import pageUIs.user.UserTopMenuUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getcurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToBrowser(WebDriver driver) {
		driver.navigate().back();
	}

	public void forWardToBrowser(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshBrowser(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Set<Cookie> getAllCookie(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookie(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	public Alert waitAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver);
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver);
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		waitAlertPresence(driver);
		return driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(WebDriver driver, String textValue) {
		driver.switchTo().alert().sendKeys(textValue);
	}

	public String getWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public void switchToWindowByID(WebDriver driver, String ortherID) {
		Set<String> actualWindow = driver.getWindowHandles();
		for (String id : actualWindow) {
			if (!id.equals(ortherID)) {
				driver.switchTo().window(id);
			}
		}
	}

	public void switchToWindowByTitlePage(WebDriver driver, String expectedTitle) {
		Set<String> actualWindow = driver.getWindowHandles();
		for (String id : actualWindow) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentWindow) {
		Set<String> actualWindow = driver.getWindowHandles();
		for (String string : actualWindow) {
			if (!string.equals(parentWindow)) {
				driver.switchTo().window(string);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getLocatorType(locatorType));
	}

	public List<WebElement> getListWebElements(WebDriver driver, String locatorType) {
		return driver.findElements(getLocatorType(locatorType));
	}

	public By getLocatorType(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else if (locatorType.startsWith("class")) {
			by = By.className(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not valid");
		}
		return by;
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}

	public void clickToElement(WebDriver driver, String xpathLocator, String... textValue) {
		getWebElement(driver, getDynamicLocator(driver, xpathLocator, textValue)).click();
	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	public void clearValueElementByPressKey(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}


	public void sendKeyToElement(WebDriver driver, String xpathLocator, String textValue, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicLocator(driver, xpathLocator, dynamicValue));
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textValue) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textValue, String... dynamicXpath) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(driver, xpathLocator, dynamicXpath)));
		select.selectByVisibleText(textValue);
	}

	public String getFirstSelectItemDefaultDropDown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public String getFirstSelectItemDefaultDropDown(WebDriver driver, String xpathLocator, String... dynamicXpath) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(driver, xpathLocator, dynamicXpath)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String locatorType, String expectedText) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);

		getWebElement(driver, parentXpath).click();

		List<WebElement> listElement = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocatorType(locatorType)));
		for (WebElement tempItem : listElement) {
			if (tempItem.getText().trim().equals(expectedText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempItem);
				tempItem.click();
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String textValue) {
		return getWebElement(driver, xpathLocator).getAttribute(textValue);
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String textValue, String... dynamicValue) {
		return getWebElement(driver, getDynamicLocator(driver, xpathLocator, dynamicValue)).getAttribute(textValue);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	public String getElementText(WebDriver driver, String xpathLocator, String... dynamicValue) {
		return getWebElement(driver, getDynamicLocator(driver, xpathLocator, dynamicValue)).getText();
	}

	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElements(driver, xpathLocator).size();
	}

	public int getElementSize(WebDriver driver, String dynamicXpath, String values) {
		return getListWebElements(driver, getDynamicLocator(driver, dynamicXpath, values)).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicLocator(driver, xpathLocator, dynamicValue));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator, String... dynamicValue) {
		WebElement element = getWebElement(driver, getDynamicLocator(driver, xpathLocator, dynamicValue));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		try {
			return getWebElement(driver, xpathLocator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... dynamicValue) {
		try {
			return getWebElement(driver, getDynamicLocator(driver, xpathLocator, dynamicValue)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void overrideGlobalConstantTimeOut(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementUnDisplayed(WebDriver driver, String xpathLocator, String... dynamicValues) {
		System.out.println("Start time: " + new Date().toString());
		overrideGlobalConstantTimeOut(driver, GlobalConstances.SHORT_TIME_OUT);
		List<WebElement> elements = getListWebElements(driver, getDynamicLocator(driver, xpathLocator, dynamicValues));
		overrideGlobalConstantTimeOut(driver, GlobalConstances.LONG_TIME_OUT);
		if (elements.size() == 0) {
			System.out.println("Element NOT in DOM");
			System.out.println("End time:" + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible UI");
			System.out.println("End time:" + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM & visible");
			return false;
		}
	}

	public boolean isElementUnDisplayed(WebDriver driver, String xpathLocator) {
		System.out.println("Start time: " + new Date().toString());
		overrideGlobalConstantTimeOut(driver, GlobalConstances.SHORT_TIME_OUT);
		List<WebElement> elements = getListWebElements(driver, xpathLocator);
		overrideGlobalConstantTimeOut(driver, GlobalConstances.LONG_TIME_OUT);
		if (elements.size() == 0) {
			System.out.println("Element NOT in DOM");
			System.out.println("End time:" + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible UI");
			System.out.println("End time:" + new Date().toString());
			return true;
		} else {
			System.out.println("Element in DOM & visible");
			return false;
		}
	}

	public boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType, String... value) {
		return getWebElement(driver, getDynamicLocator(driver, locatorType, value)).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();

	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		JavascriptExecutor jsExecutor;
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			JavascriptExecutor jsExecutor;

			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor;
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorType(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... textValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorType(getDynamicLocator(driver, locatorType, textValue))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getLocatorType(locatorType)));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getLocatorType(locatorType)));
	}

	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, xpathLocator)));
	}

	public void waitForClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getLocatorType(locatorType)));
	}

	public void waitForClickable(WebDriver driver, String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstances.LONG_TIME_OUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getLocatorType(getDynamicLocator(driver, locatorType, dynamicValue))));
	}

	public UserAddressesPageObject openAddressLink(WebDriver driver) {
		waitForElementVisible(driver, BaseNopCommerceUI.USER_ADDRESSES_LINK);
		clickToElement(driver, BaseNopCommerceUI.USER_ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserOrderPageObject openOrderLink(WebDriver driver) {
		waitForElementVisible(driver, BaseNopCommerceUI.USER_ORDERS_LINK);
		clickToElement(driver, BaseNopCommerceUI.USER_ORDERS_LINK);
		return PageGeneratorManager.getOrderPage(driver);
	}

	public UserChangePasswordPageObject openChangePasswordLink(WebDriver driver) {
		waitForElementVisible(driver, BaseNopCommerceUI.USER_CHANGE_PASSWORD_LINK);
		clickToElement(driver, BaseNopCommerceUI.USER_CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getUserChangePasswordPage(driver);
	}

	public UserCustomerInfoPageObject openCustomerInfoLink(WebDriver driver) {
		waitForElementVisible(driver, BaseNopCommerceUI.USER_CUSTOMER_INFO_LINK);
		clickToElement(driver, BaseNopCommerceUI.USER_CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public static String locator_1_Parameter(String namePage, String dynamicValue) {
		return String.format(namePage, dynamicValue);
	}

	public static String locator_2_Parameter(String namePage, String nameArea, String dynamicValue) {
		return String.format(namePage, nameArea, dynamicValue);
	}

	public UserSearchPageObject openSearchLink(WebDriver driver, String namePage, String nameArea, String dynamicValue) {
		waitForClickable(driver, BasePage.locator_2_Parameter(namePage, nameArea, dynamicValue));
		clickToElement(driver, BasePage.locator_2_Parameter(namePage, nameArea, dynamicValue));
		return PageGeneratorManager.getSearchPage(driver);
	}

	public UserDeskTopPageObject openDesktopProduct(WebDriver driver) {
		hoverMouseToElement(driver, UserTopMenuUI.COMPUTER_LINK);
		clickToElement(driver, UserTopMenuUI.DESKTOP_LINK);
		return PageGeneratorManager.getDeskTopPage(driver);
	}

	public UserNoteBookPageObject openNoteBookProduct(WebDriver driver) {
		hoverMouseToElement(driver, UserTopMenuUI.COMPUTER_LINK);
		clickToElement(driver, UserTopMenuUI.NOTEBOOKS_LINK);
		return PageGeneratorManager.getNoteBookPage(driver);
	}

	// Apply open Page by name, sử dụng 1 function để call nhiều page.
	// Cách 1:
	public String getDynamicLocator(WebDriver driver, String locator, String... textValues) {
		if (locator.startsWith("xpath=")) {
			locator = String.format(locator, (Object[]) textValues);
		}
		return locator;
	}

	public BasePage openPageObjectByName(WebDriver driver, String textValue) {
		waitForElementVisible(driver, BaseNopCommerceUI.USER_MYACCOUNT_DYNAMIC_LINK, textValue);
		clickToElement(driver, BaseNopCommerceUI.USER_MYACCOUNT_DYNAMIC_LINK, textValue);
		switch (textValue) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrderPage(driver);
		case "Change password":
			return PageGeneratorManager.getUserChangePasswordPage(driver);
		default:
			throw new RuntimeException("Invalid pagename in My account");
		}
	}

	// Cách 2:
	public void openPageObjectByName_(WebDriver driver, String textValue) {
		waitForElementVisible(driver, BaseNopCommerceUI.USER_MYACCOUNT_DYNAMIC_LINK, textValue);
		clickToElement(driver, BaseNopCommerceUI.USER_MYACCOUNT_DYNAMIC_LINK, textValue);

	}

	public void uploadMultipleFile(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstances.UPLOAD_FILE;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, HomePageJQueryUI.UPLOAD_FILE_BUTTON).sendKeys(fullFileName);

	}

	public boolean isDisplayLoadedFileByText(WebDriver driver, String titleFile) {
		waitForElementVisible(driver, HomePageJQueryUI.LOADED_FILE_DYNAMIC, titleFile);
		return isElementDisplayed(driver, HomePageJQueryUI.LOADED_FILE_DYNAMIC, titleFile);
	}

	public void clickToStartButton(WebDriver driver) {
		List<WebElement> startButtons = getListWebElements(driver, HomePageJQueryUI.START_UPLOAD_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
	}

	// Apply Page Element Component
	/**
	 * Input TextBox with Dynamic Locator by ID
	 * 
	 * @author Tan ProMax
	 * @param driver
	 * @param idTextBox
	 * @param value
	 */
	public void inputTextBoxByID(WebDriver driver, String idTextBox, String value) {
		waitForElementVisible(driver, BaseNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, idTextBox);
		sendKeyToElement(driver, BaseNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, value, idTextBox);
	}

	/**
	 * Select Radio with Dynamic Locator by Text
	 * 
	 * @author Tan ProMax
	 * @param driver
	 * @param text
	 */
	public void selectRadioButtonByText(WebDriver driver, String text) {
		waitForElementVisible(driver, BaseNopCommerceUI.DYNAMIC_RADIO_BY_TEXT, text);
		checkToDefaultCheckboxRadio(driver, BaseNopCommerceUI.DYNAMIC_RADIO_BY_TEXT, text);
	}

	/**
	 * Select Dropdown List with Dynamic Locator by Name Attribute
	 * 
	 * @author Tan ProMax
	 * @param driver
	 * @param nameAttribute
	 * @param selectedValue
	 */
	public void selectDropdownByNameAttribute(WebDriver driver, String nameAttribute, String selectedValue) {
		waitForClickable(driver, BaseNopCommerceUI.DYNAMIC_DROPDOWNLIST_BY_NAME_ATTRIBUTE, nameAttribute);
		selectItemInDefaultDropdown(driver, BaseNopCommerceUI.DYNAMIC_DROPDOWNLIST_BY_NAME_ATTRIBUTE, selectedValue, nameAttribute);
	}

	/**
	 * Select Dropdown List with Dynamic Locator by Name Attribute
	 * @author Tan ProMax
	 * @param driver
	 * @param text
	 */
	public void checkCheckBoxByText(WebDriver driver, String text) {
		waitForElementVisible(driver, BaseNopCommerceUI.DYNAMIC_CHECKBOX_BY_TEXT, text);
		uncheckToDefaultCheckbox(driver, BaseNopCommerceUI.DYNAMIC_CHECKBOX_BY_TEXT, text);
	}

	/**
	 * Verify TextBox by ID
	 * @author Tan ProMax
	 * @param driver
	 * @param idTextBox
	 * @param attribute
	 * @return String
	 */
	public String verifyTextBoxByID(WebDriver driver, String idTextBox, String attribute) {
		waitForElementVisible(driver, BaseNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, idTextBox);
		return getElementAttribute(driver, BaseNopCommerceUI.DYNAMIC_TEXTBOX_BY_ID, attribute, idTextBox);

	}

	public boolean verifyRadioCheckedByText(WebDriver driver, String text) {
		waitForElementVisible(driver, BaseNopCommerceUI.DYNAMIC_RADIO_BY_TEXT, text);
		return isElementSelected(driver, BaseNopCommerceUI.DYNAMIC_RADIO_BY_TEXT, text);

	}

	public String verifyDropDownListByNameAttribute(WebDriver driver, String nameAttribute) {
		waitForElementVisible(driver, BaseNopCommerceUI.DYNAMIC_DROPDOWNLIST_BY_NAME_ATTRIBUTE, nameAttribute);
		return getFirstSelectItemDefaultDropDown(driver, BaseNopCommerceUI.DYNAMIC_DROPDOWNLIST_BY_NAME_ATTRIBUTE, nameAttribute);
	}

	public boolean verifyCheckBoxByText(WebDriver driver, String text) {
		waitForElementVisible(driver, BaseNopCommerceUI.DYNAMIC_CHECKBOX_BY_TEXT, text);
		return isElementSelected(driver, BaseNopCommerceUI.DYNAMIC_CHECKBOX_BY_TEXT, text);
	}

	public UserHomePO openUserSite(WebDriver driver, String url) {
		openPageURL(driver, url);
		return pageObjects.wordpress.endUser.PageGeneratorManager.getUserHome(driver);
	}
	public AdminLoginPO openToAdminSiteUrl(WebDriver driver, String url) {
		openPageURL(driver, url);
		return pageObjects.wordpress.admin.PageGeneratorManager.getAdminLoginPage(driver);
	}

}
