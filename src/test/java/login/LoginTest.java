package login;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import config.Base;
import webpages.LandingPage;
import webpages.LoginPage;

public class LoginTest extends Base {
	
	private WebDriver webDriver;
	private final String baseURL;

	public LoginTest() throws Exception {
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
		 webDriver.get(baseURL+"/login/");
		
		//Navigate to login page from landing page
		LandingPage lpage = new LandingPage(webDriver);
		lpage.getLogin().click();
		
		LoginPage loginPage = new LoginPage(webDriver);
		//System.out.println("OUTPUT HERE" + loginPage.getTitle().getText());
		AssertJUnit.assertEquals(loginPage.getTitle().getText(),"Login");
	}
	
	
	@Test()
	public void badLoginTest() throws Exception {
		webDriver.get(baseURL+"");

		//Navigate to login page from landing page
		LandingPage lpage = new LandingPage(webDriver);
		lpage.getLogin().click();
		
		//Login using test credentials
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.getUsername().sendKeys("badusername");
		loginPage.getPassword().sendKeys("bad password");
		loginPage.getLoginBtn().click();
		
		AssertJUnit.assertEquals(loginPage.getLoginWarning().getText(), "Wrong username or password");
	}
	
	
	@Test
	public void testEmptyPassword() {
		//Navigate to login page from landing page
		LandingPage lpage = new LandingPage(webDriver);
		lpage.getLogin().click();
				
				//Login using test credentials
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.getUsername().clear();
		loginPage.getUsername().sendKeys("badusername");
		loginPage.getPassword().clear();
		loginPage.getPassword().sendKeys("");
		boolean isEnable = loginPage.getLoginBtn().isEnabled();
		
		AssertJUnit.assertEquals(isEnable, true);
	}
	
	@Test
	public void testEmptyUsername() {
		//Navigate to login page from landing page
		LandingPage lpage = new LandingPage(webDriver);
		lpage.getLogin().click();
				
				//Login using test credentials
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.getUsername().clear();
		loginPage.getUsername().sendKeys("");
		loginPage.getPassword().clear();
		loginPage.getPassword().sendKeys("badpassword");
		boolean isEnable = loginPage.getLoginBtn().isEnabled();
		
		AssertJUnit.assertEquals(isEnable, true);
	}

	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] userData=new Object[1][2];
		
		//Data set 1
		userData[0][0] ="test";
		userData[0][1] ="test";
		
		//Data set 2
		userData[0][0] ="admin";
	    userData[0][1] ="admin";
	    
	    return userData;
		
	}
	
	@AfterTest
	public void close() {
		webDriver.close();
	}
	
	

}
