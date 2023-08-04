package pageUIs.wordpress.endUser;

public class UserHomeUI {
	public static final String POST_TITLE = "xpath=//article//h2/a[text()='%s']";
	public static final String POST_DATE_TIME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div//time[text()='%s']";
	public static final String POST_BODY = "xpath=//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String POST_AUTHOR = "xpath=//a[text()='%s']/parent::h2/following-sibling::div/span[@class='byline']//a[text()='%s']";
	
	public static final String DETAIL_POST_TITLE = "xpath=//article/header/h1[text()='%s']";
	public static final String DETAIL_POST_BODY = "xpath=//article//h1[text()='%s']/ancestor::header/following-sibling::div//p[text()='%s']";
	public static final String DETAIL_POST_AUTHOR = "xpath=//article//h1[text()='%s']/ancestor::header//span[@class='byline']//a[text()='%s']";
	public static final String DETAIL_POST_DATE_TIME = "xpath=//article//h1[text()='%s']/following-sibling::div//time[text()='%s']";
	
	public static final String SEARCH_PRODUCT_TEXTBOX = "xpath=//form[@class='woocommerce-product-search']/input[@type='search']";
	public static final String SEARCH_PRODUCT_BUTTON = "xpath=//form[@class='woocommerce-product-search']/button";
	
	
	
}
