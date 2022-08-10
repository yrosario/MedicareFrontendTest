package login;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import config.Base;
import webpages.LoginPage;
import webpages.RegistrationPage;

public class RegistrationTest extends Base {
	
	private WebDriver webDriver;

	public RegistrationTest() throws Exception {
		super();
		super.initializerDriver();
		webDriver = super.getWebDriver();
		
	}

	@Test
	public void validatePageTitleTest() {
		 webDriver.get("http://localhost:4200/register");
		
		
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		String result = regPage.getTitle().getText();
		Assert.assertEquals(result,"Register New User");
	}
	
	@Test
	public void ExistingUserTest() {
        webDriver.get("http://localhost:4200/register");
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		regPage.getFirtname().sendKeys("test");
		regPage.getLastname().sendKeys("test");
		regPage.getEamil().sendKeys("test@test.com");
		regPage.getUsername().sendKeys("test");
		regPage.getPassword().sendKeys("test");
		regPage.getRetyPassword().sendKeys("test");
		regPage.getRegisterBtn().click();
		
		String result = regPage.getInvalidMessage().getText();
		
		Assert.assertEquals(result, "The was an error with form. Review the form!");
	}
	
	@Test
	public void InvalidPasswodTest() {
        webDriver.get("http://localhost:4200/register");
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		regPage.getFirtname().sendKeys("test");
		regPage.getLastname().sendKeys("test");
		regPage.getEamil().sendKeys("test@test.com");
		regPage.getUsername().sendKeys("test");
		regPage.getPassword().sendKeys("test");
		regPage.getRetyPassword().sendKeys("test2");
		regPage.getRegisterBtn().click();
		
		String result = regPage.getInvalidPasswordMsg().getText();
		
		Assert.assertEquals(result, "Password doesn't match");
	}
	
	@Test
	public void ValidRegistrationTest() {
        webDriver.get("http://localhost:4200/register");
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		int rndInt = (int) (1000000 *  Math.random());
		
		
		regPage.getFirtname().sendKeys("test101");
		regPage.getLastname().sendKeys("test101");
		regPage.getEamil().sendKeys("test@test.com");
		regPage.getUsername().sendKeys("test"+rndInt);
		regPage.getPassword().sendKeys("test101");
		regPage.getRetyPassword().sendKeys("test101");
		regPage.getRegisterBtn().click();
		
		LoginPage loginPage = new LoginPage(webDriver);
		
		String result = loginPage.getTitle().getText();
		
		
		
		Assert.assertEquals(result, "Login");
	}
	
	
	@Test
	public void disableBtnTest() {
        webDriver.get("http://localhost:4200/register");
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		int rndInt = (int) (1000000 *  Math.random());
		
		
		regPage.getFirtname().sendKeys("");
		regPage.getLastname().sendKeys("test101");
		regPage.getEamil().sendKeys("test@test.com");
		regPage.getUsername().sendKeys("test"+rndInt);
		regPage.getPassword().sendKeys("test101");
		regPage.getRetyPassword().sendKeys("test101");
		regPage.getRegisterBtn().click();
		
		
		boolean result = regPage.getRegisterBtn().isDisplayed();
		
		
		
		Assert.assertEquals(result, true);
	}
	
	@Test
	public void invalidEmailTest() {
        webDriver.get("http://localhost:4200/register");
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		int rndInt = (int) (1000000 *  Math.random());
		
		
		regPage.getFirtname().sendKeys("test101");
		regPage.getLastname().sendKeys("test101");
		regPage.getEamil().sendKeys("testemail");
		regPage.getUsername().sendKeys("test"+rndInt);
		regPage.getPassword().sendKeys("test101");
		regPage.getRetyPassword().sendKeys("test101");
		regPage.getRegisterBtn().click();
		
		
		boolean result = regPage.getRegisterBtn().isDisplayed();
		
		
		
		Assert.assertEquals(result, true);
	}
	
	@AfterTest
	public void close() {
		webDriver.close();
	}
	
	

}
