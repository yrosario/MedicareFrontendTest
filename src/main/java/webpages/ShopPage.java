package webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
	
	private WebDriver driver;
	
	By title= By.id("product-view-title");
	By productItems= By.id("prod-item");
	By searchBar= By.id("search-bar");
	By searchButton= By.id("search-btn");
	By category= By.id("category-id");
	
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public List<WebElement> getProductsList(){
		return driver.findElements(productItems);
	}
	
	public WebElement getSearchBar() {
		return driver.findElement(searchBar);
	}
	
	public WebElement getSearchBtn() {
		return driver.findElement(searchButton);
	}
	
	public List<WebElement> getCategory() {
		return driver.findElements(category);
	}

	

}
