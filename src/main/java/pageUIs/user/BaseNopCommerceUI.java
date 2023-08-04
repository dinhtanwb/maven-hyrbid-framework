package pageUIs.user;

public class BaseNopCommerceUI {
	public static final String USER_ADDRESSES_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Addresses']";
	public static final String USER_ORDERS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Orders']";
	public static final String USER_CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Customer info']";
	public static final String USER_CHANGE_PASSWORD_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='Change password']";
	public static final String USER_MYACCOUNT_DYNAMIC_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_RADIO_BY_TEXT = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_DROPDOWNLIST_BY_NAME_ATTRIBUTE = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_TEXT = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	
	
	
	
}
