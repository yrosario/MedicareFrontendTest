package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	By username=By.id("login-username-input");
	By password=By.id("login-password-input");
	By loginBtn=By.id("login-btn");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
	
	

}
