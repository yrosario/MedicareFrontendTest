package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	private WebDriver driver;
	
	By signin=By.id("nav-login");
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	

}
