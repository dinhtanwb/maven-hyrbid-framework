package pageObjects.saucelabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelabs.HomePageUI;

public class HomePO extends BasePage{

	WebDriver driver;
	public HomePO(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToProductSortDropdownByText(String itemText) {
		waitForClickable(driver, HomePageUI.SORTING_DROPDOWN);
		selectItemInDefaultDropdown(driver, HomePageUI.SORTING_DROPDOWN, itemText);
	}
	public boolean isSortingProductByASC() {
		//Tao ra 1 list trong
		List<String> productList = new ArrayList<String>();
		
		//Get all item in list tren UI
		List<WebElement> item = getListWebElements(driver, HomePageUI.TITLE_PRODUCT_IN_LIST);
		
		
		//Add item vao list da tao
		for (WebElement webElement : item) {
			productList.add(webElement.getText());
			System.out.println("Product in UI: " + webElement.getText());
		}
		
		//Tao ra 1 list moi de copy
		List<String> copyProductList = new ArrayList<String>();
		
		for (String string : productList) {
			copyProductList.add(string);
		}
		
		//Sort List da duoc copy
		Collections.sort(copyProductList);
		
		for (String string : copyProductList) {
			System.out.println("Product sau khi SORT: " + string);
		}
		
		
		//So sanh 2 list
		return productList.equals(copyProductList);
	}
	public boolean isSortingProductByDESC() {
		//Tao ra 1 list trong
				List<String> productList = new ArrayList<String>();
				
				//Get all item in list tren UI
				List<WebElement> item = getListWebElements(driver, HomePageUI.TITLE_PRODUCT_IN_LIST);
				
				
				//Add item vao list da tao
				for (WebElement webElement : item) {
					productList.add(webElement.getText());
					System.out.println("Product in UI: " + webElement.getText());
				}
				
				//Tao ra 1 list moi de copy
				List<String> copyProductList = new ArrayList<String>();
				
				for (String string : productList) {
					copyProductList.add(string);
				}
				
				//Sort List da duoc copy
				Collections.sort(copyProductList);
				Collections.reverse(copyProductList);
				
				for (String string : copyProductList) {
					System.out.println("Product sau khi SORT: " + string);
				}
				
				//So sanh 2 list
				return productList.equals(copyProductList);
		
		
	}
	public boolean isSortingProductByPriceASC() {

		//Tao ra 1 list trong
		List<Float> productList = new ArrayList<Float>();
		
		//Get all item in list tren UI
		List<WebElement> item = getListWebElements(driver, HomePageUI.PRICE_PRODUCT_IN_LIST);
		
		
		//Add item vao list da tao
		for (WebElement webElement : item) {
			productList.add(Float.parseFloat(webElement.getText().replace("$", "")));
			System.out.println("Product in UI: " + webElement.getText());
		}
		
		//Tao ra 1 list moi de copy
		List<Float> copyProductList = new ArrayList<Float>();
		
		for (Float price : productList) {
			copyProductList.add(price);
		}
		
		//Sort List da duoc copy
		Collections.sort(copyProductList);
		
		for (Float price : copyProductList) {
			System.out.println("Product sau khi SORT: " + price);
		}
		
		
		//So sanh 2 list
		return productList.equals(copyProductList);
	
	}
	public boolean isSortingProductByPriceDESC() {
		//Tao ra 1 list trong
				List<Float> productList = new ArrayList<Float>();
				
				//Get all item in list tren UI
				List<WebElement> item = getListWebElements(driver, HomePageUI.PRICE_PRODUCT_IN_LIST);
				
				
				//Add item vao list da tao
				for (WebElement webElement : item) {
					productList.add(Float.parseFloat(webElement.getText().replace("$", "")));
					System.out.println("Product in UI: " + webElement.getText());
				}
				
				//Tao ra 1 list moi de copy
				List<Float> copyProductList = new ArrayList<Float>();
				
				for (Float price : productList) {
					copyProductList.add(price);
				}
				
				//Sort List da duoc copy
				Collections.sort(copyProductList);
				Collections.reverse(copyProductList);
				
				for (Float price : copyProductList) {
					System.out.println("Product sau khi SORT: " + price);
				}
				
				
				//So sanh 2 list
				return productList.equals(copyProductList);
	}

}
