package pageUIs.jQuery;

public class HomePageJQueryUI {
	public static final String PAGINATION_NUMBER_DYNAMIC = "xpath=//ul[@class='qgrd-pagination-ul']//a[text()='%s']";
	public static final String NUMBER_PAGE = "xpath=//ul[@class='qgrd-pagination-ul']/li";
	public static final String DATA_ROW_PER_PAGE = "xpath=//tbody/tr";
	public static final String COUNTRY_ROW_PER_PAGE = "xpath=//tbody//td[@data-key='country']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//th[text()='%s']/preceding-sibling::*";
	public static final String TEXT_BOX_BY_COLUMN_INDEX_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String CHECKBOX_BY_COLUMN_INDEX_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input";
	public static final String ICON_BY_ROW_INDEX_TEXT = "xpath=//tbody/tr[%s]//button[@title='%s']";
	
	
	
	
	public static final String UPLOAD_FILE_BUTTON = "xpath=//input[@type='file']";
	public static final String START_UPLOAD_BUTTON = "css=tbody button.start";
	public static final String LOADED_FILE_DYNAMIC = "xpath=//td/p[@class='name' and text()='%s']";
	
	public static final String FILE_IMAGE_UPLOADED_SUCCESS = "xpath=//span/a[contains(@href,'%s')]";
	public static final String FILE_LINK_UPLOADED_SUCCESS = "xpath=//p/a[contains(@href,'Csharp.jpg')]";
	
	
}
