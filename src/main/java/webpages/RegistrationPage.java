package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	private WebDriver driver;
	
	By title=By.tagName("h1");
	By firstname=By.id("firstname-input");
	By lastname=By.id("lastname-input");
	By email=By.id("email-input");
	By username=By.id("username-input");
	By password=By.id("password-input");
	By retyPassword=By.id("retyPassowrd-input");
	By registerBtn=By.id("reg-btn-div");
	
	

	By invalidMsg=By.id("badFormInputMsg");
	By invalidPasswordMsg=By.id("invalidPassMsg");
	By successRegMsg=By.id("success-reg-msg");
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
	

	public WebElement getFirtname() {
		return driver.findElement(firstname);
	}
	
	public WebElement getLastname() {
		return driver.findElement(lastname);
	}
	
	public WebElement getEamil() {
		return driver.findElement(email);
	}
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getRetyPassword() {
		return driver.findElement(retyPassword);
	}
	
	public WebElement getRegisterBtn() {
		return driver.findElement(registerBtn);
	}
	
	public WebElement getInvalidMessage() {
		return driver.findElement(invalidMsg);
	}
	
	public WebElement getInvalidPasswordMsg() {
		return driver.findElement(invalidPasswordMsg);
	}
	
	public WebElement getSuccessRegistrationMsg() {
		return driver.findElement(successRegMsg);
	}
	

}
