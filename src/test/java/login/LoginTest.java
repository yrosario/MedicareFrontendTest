package login;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import config.Base;
import webpages.LandingPage;
import webpages.LoginPage;

public class LoginTest extends Base {
	
	private WebDriver webDriver;

	public LoginTest() throws Exception {
		super();
		super.initializerDriver();
		webDriver = super.getWebDriver();
		
	}

	@Test
	public void validatePageTitleTest() {
		 webDriver.get("http://localhost:4200/login/");
		
		//Navigate to login page from landing page
		LandingPage lpage = new LandingPage(webDriver);
		lpage.getLogin().click();
		
		LoginPage loginPage = new LoginPage(webDriver);
		//System.out.println("OUTPUT HERE" + loginPage.getTitle().getText());
		Assert.assertEquals(loginPage.getTitle().getText(),"Login");
	}
	
	
	@Test()
	public void badLoginTest() throws Exception {
		webDriver.get("http://localhost:4200");

		//Navigate to login page from landing page
		LandingPage lpage = new LandingPage(webDriver);
		lpage.getLogin().click();
		
		//Login using test credentials
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.getUsername().sendKeys("badusername");
		loginPage.getPassword().sendKeys("bad password");
		loginPage.getLoginBtn().click();
		
		Assert.assertEquals(loginPage.getLoginWarning().getText(), "Wrong username or password");
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
		
		Assert.assertEquals(isEnable, true);
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
		
		Assert.assertEquals(isEnable, true);
	}
//	
//	@Test(dataProvider="getData")
//	public void getLogin(String username, String password) throws Exception {
//		webDriver.get("http://localhost:4200");
//
//		//Navigate to login page from landing page
//		LandingPage lpage = new LandingPage(webDriver);
//		lpage.getLogin().click();
//		
//		//Login using test credentials
//		LoginPage loginPage = new LoginPage(webDriver);
//		loginPage.getUsername().sendKeys(username);
//		loginPage.getPassword().sendKeys(password);
//		loginPage.getLoginBtn().click();
//			
//	}
	
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
