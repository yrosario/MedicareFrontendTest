package webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	
	private WebDriver driver;
	
	
	By title=By.id("manage-prod-title");
	By addBtn=By.id("add-btn");
	
	
	By header=By.className("prod-header-row");
	By price=By.id("price");
	
	
	By editBtn=By.id("prod-edit-btn");

	By disableBtn=By.id("prod-delete-btn");
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	

	public WebElement getAddBtn() {
		return driver.findElement(addBtn);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	
	public List<WebElement> getPrices() {
		return driver.findElements(price);
	}
	public List<WebElement> getEditBtn() {
		return driver.findElements(editBtn);
	}
	
	public List<WebElement> getDisableBtn() {
		return driver.findElements(disableBtn);
	}


	

}
