package pageUIs.wordpress.admin;

public class AdminPostAddNewPageUI {
	public static final String PAGE_TITLE = "css=h1.wp-block-post-title";
	public static final String PAGE_BODY_BUTTON = "css=p[class*='block-editor-default']";
	public static final String PAGE_BODY_TEXTAREA = "css=p.block-editor-rich-text__editable";
	public static final String PUBLISH_BUTTON = "css=button.editor-post-publish-panel__toggle";
	public static final String UPDATE_BUTTON = "css=button.editor-post-publish-button";
	public static final String REPUBLISH_BUTTON = "css=button.editor-post-publish-button";
	public static final String POST_PUBLISHED_MSG = "xpath=//div/div[contains(text(),'%s')]";
	public static final String COLUMN_INDEX_BY_TEXT = "xpath=//thead/tr/th[text()='%s']/preceding-sibling::*";
	public static final String TEXTBOX_BY_COLUMN_INDEX_ROW_INDEX = "xpath=//tbody/tr/*[%s]/a";
	
	
}
