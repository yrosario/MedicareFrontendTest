package login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.Base;
import webpages.LandingPage;
import webpages.LoginPage;

public class LoginTest extends Base {
	
	private WebDriver webDriver;

	public LoginTest() throws Exception {
		super();
	}

	@Test(dataProvider="getData")
	public void getLogin(String username, String password) throws Exception {
		super.initializerDriver();
		webDriver = super.getWebDriver();
		webDriver.get("http://localhost:4200");
		
		//Navigate to login page from landing page
		LandingPage lpage = new LandingPage(webDriver);
		lpage.getLogin().click();
		
		//Login using test credentials
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.getUsername().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginBtn().click();
			
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
}
