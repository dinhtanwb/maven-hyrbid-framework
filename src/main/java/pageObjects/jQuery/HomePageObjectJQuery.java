package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageJQueryUI;

public class HomePageObjectJQuery extends BasePage {
	WebDriver driver;

	public HomePageObjectJQuery(WebDriver driver) {
		this.driver = driver;
	}

	public void selectPaginationByText(String string) {
		waitForElementVisible(driver, HomePageJQueryUI.PAGINATION_NUMBER_DYNAMIC, string);
		clickToElement(driver, HomePageJQueryUI.PAGINATION_NUMBER_DYNAMIC, string);
	}

	public List<String> getAllRowinAllPage() {
		int totalPage = getElementSize(driver, HomePageJQueryUI.NUMBER_PAGE);
		List<String> allRowDataPerAllPage = new ArrayList<String>();
		for (int i = 1; i <= totalPage; i++) {
			clickToElement(driver, HomePageJQueryUI.PAGINATION_NUMBER_DYNAMIC, String.valueOf(i));
			List<WebElement> allRowPerPage = getListWebElements(driver, HomePageJQueryUI.DATA_ROW_PER_PAGE);
			for (WebElement webElement : allRowPerPage) {

				allRowDataPerAllPage.add(webElement.getText());
			}

		}
		for (String valueRow : allRowDataPerAllPage) {
			System.out.println("----------------------");
			System.out.println(valueRow);
		}
		return allRowDataPerAllPage;
	}

	public void sendKeyToDynamicTexboxByColumnTextAtRowNumber(String nameColumn, String rowNumber, String textValue) {
		int indexColumn = getElementSize(driver, HomePageJQueryUI.COLUMN_INDEX_BY_NAME, nameColumn) + 1;
		waitForElementVisible(driver, HomePageJQueryUI.TEXT_BOX_BY_COLUMN_INDEX_ROW_INDEX, rowNumber, String.valueOf(indexColumn));
		sendKeyToElement(driver, HomePageJQueryUI.TEXT_BOX_BY_COLUMN_INDEX_ROW_INDEX, textValue, rowNumber, String.valueOf(indexColumn));
	}

	public void selectDropdownByColumnNameAtRowNumber(String nameColumn, String rowNumber, String textValue) {
		int indexColumn = getElementSize(driver, HomePageJQueryUI.COLUMN_INDEX_BY_NAME, nameColumn) + 1;
		waitForClickable(driver, HomePageJQueryUI.DROPDOWN_BY_COLUMN_INDEX_ROW_INDEX, rowNumber, String.valueOf(indexColumn));
		selectItemInDefaultDropdown(driver, HomePageJQueryUI.DROPDOWN_BY_COLUMN_INDEX_ROW_INDEX, textValue, rowNumber, String.valueOf(indexColumn));
		
	}
	public void checkCheckboxByColumnNameAtRowNumber(String nameColumn, String rowNumber) {
		int indexColumn = getElementSize(driver, HomePageJQueryUI.COLUMN_INDEX_BY_NAME, nameColumn) + 1;
		waitForClickable(driver, HomePageJQueryUI.CHECKBOX_BY_COLUMN_INDEX_ROW_INDEX, rowNumber, String.valueOf(indexColumn));
		checkToDefaultCheckboxRadio(driver, HomePageJQueryUI.CHECKBOX_BY_COLUMN_INDEX_ROW_INDEX, rowNumber, String.valueOf(indexColumn));
		
	}
	public void uncheckCheckboxByColumnNameAtRowNumber(String nameColumn, String rowNumber) {
		int indexColumn = getElementSize(driver, HomePageJQueryUI.COLUMN_INDEX_BY_NAME, nameColumn) + 1;
		waitForClickable(driver, HomePageJQueryUI.DROPDOWN_BY_COLUMN_INDEX_ROW_INDEX, rowNumber, String.valueOf(indexColumn));
		checkToDefaultCheckboxRadio(driver, HomePageJQueryUI.DROPDOWN_BY_COLUMN_INDEX_ROW_INDEX, rowNumber, String.valueOf(indexColumn));
		
	}
	public void clickToIconByRowIndexAtTitle(String rowNumber, String iconName) {
		waitForClickable(driver, HomePageJQueryUI.ICON_BY_ROW_INDEX_TEXT, rowNumber, iconName);
		clickToElement(driver, HomePageJQueryUI.ICON_BY_ROW_INDEX_TEXT, rowNumber, iconName);
	}

	public boolean uploadFileSuccess(String fileNameUploaded) {
		waitForElementVisible(driver, HomePageJQueryUI.FILE_IMAGE_UPLOADED_SUCCESS, fileNameUploaded);
		waitForElementVisible(driver, HomePageJQueryUI.FILE_LINK_UPLOADED_SUCCESS, fileNameUploaded);
		if(isElementDisplayed(driver, HomePageJQueryUI.FILE_IMAGE_UPLOADED_SUCCESS, fileNameUploaded) && isElementDisplayed(driver, HomePageJQueryUI.FILE_LINK_UPLOADED_SUCCESS, fileNameUploaded)) {
			return true;
		}
		return false;
	}
	
	
	
}
