package pageUIs.wordpress.admin;

public class AdminPostAllPageUI {
	public static final String ADD_NEW_BUTTON = "xpath=//h1[contains(text(),'Posts')]/following-sibling::a";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='post-search-input']";
	public static final String SEARCH_BUTTON = "xpath=//input[@id='search-submit']";
	public static final String POST_TITLE_IN_ROW = "xpath=//table//tbody[@id='the-list']//strong/a[text()='%s']";
	public static final String SELECT_ACTION_DROPDOWN = "xpath=//select[@name='action']";
	public static final String APPLY_BUTTON = "xpath=//input[@id='doaction']";
	public static final String VERIFY_MESSAGE_WITH_ACTION = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String CHECKBOX_IN_ROW_BY_TEXT = "xpath=//a[text()='%s']/ancestor::td//preceding-sibling::th/input";
	
}
