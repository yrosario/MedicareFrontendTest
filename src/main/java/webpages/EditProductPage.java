package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProductPage {
	
	private WebDriver driver;
	
	
	By title=By.id("eidt-prod-title");
	
	By id=By.id("prod-id");
	By name=By.id("prod-name-input");
	By brand=By.id("prod-brand-input");
	By category=By.id("category-select");
	By price=By.id("prod-price-input");
	By qty=By.id("prod-qty-input");
	By updateBtn=By.id("prod-submit-btn");
	
	By updateSuccessMsg=By.id("updat-msg-succ-div");

	
	public EditProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getId() {
		return driver.findElement(id);
	}

	public WebElement getName() {
		return driver.findElement(name);
	}

	public WebElement getBrand() {
		return driver.findElement(brand);
	}

	public WebElement getCategory() {
		return driver.findElement(category);
	}

	public WebElement getPrice() {
		return driver.findElement(price);
	}

	public WebElement getQty() {
		return driver.findElement(qty);
	}
	
	public WebElement getUpdateBtn() {
		return driver.findElement(updateBtn);
	}
	
	public WebElement getUpdateSuccessMsg() {
		return driver.findElement(updateSuccessMsg);
	}


	

}
