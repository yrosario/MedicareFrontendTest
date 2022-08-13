package login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import config.Base;
import webpages.LoginPage;
import webpages.RegistrationPage;

public class RegistrationTest extends Base {
	
	private WebDriver webDriver;
	private final String baseURL;

	public RegistrationTest() throws Exception {
		super();
		super.initializerDriver();
		webDriver = super.getWebDriver();
		
		Properties prop = new Properties();
		FileInputStream fileStream = new FileInputStream("src"
				+ "/main/resources/data.properties");
		
		prop.load(fileStream);
		baseURL = prop.getProperty("baseUrl");
		
		
		if(baseURL.equals("") || baseURL == null) {
			throw new Exception("baseURL is empty or is NULL");
		}
		
	}

	@Test
	public void validatePageTitleTest() {
		 webDriver.get(baseURL+"/register");
		
		
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		String result = regPage.getTitle().getText();
		AssertJUnit.assertEquals(result,"Register New User");
	}
	
	@Test
	public void ExistingUserTest() {
        webDriver.get(baseURL+"/register");
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		regPage.getFirtname().sendKeys("test");
		regPage.getLastname().sendKeys("test");
		regPage.getEamil().sendKeys("test@test.com");
		regPage.getUsername().sendKeys("test");
		regPage.getPassword().sendKeys("test");
		regPage.getRetyPassword().sendKeys("test");
		regPage.getRegisterBtn().click();
		
		String result = regPage.getInvalidMessage().getText();
		
		AssertJUnit.assertEquals(result, "The was an error with form. Review the form!");
	}
	
	@Test
	public void InvalidPasswodTest() {
        webDriver.get(baseURL+"/register");
		RegistrationPage regPage = new RegistrationPage(webDriver);
		
		regPage.getFirtname().sendKeys("test");
		regPage.getLastname().sendKeys("test");
		regPage.getEamil().sendKeys("test@test.com");
		regPage.getUsername().sendKeys("test");
		regPage.getPassword().sendKeys("test");
		regPage.getRetyPassword().sendKeys("test2");
		regPage.getRegisterBtn().click();
		
		String result = regPage.getInvalidPasswordMsg().getText();
		
		AssertJUnit.assertEquals(result, "Password doesn't match");
	}
	
	@Test
	public void ValidRegistrationTest() {
        webDriver.get(baseURL+"/register");
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
		
		
		
		AssertJUnit.assertEquals(result, "Login");
	}
	
	
	@Test
	public void disableBtnTest() {
        webDriver.get(baseURL+"/register");
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
		
		
		
		AssertJUnit.assertEquals(result, true);
	}
	
	@Test
	public void invalidEmailTest() {
        webDriver.get(baseURL+"/register");
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
		
		
		
		AssertJUnit.assertEquals(result, true);
	}
	
	@AfterTest
	public void close() {
		webDriver.close();
	}
	
	

}
