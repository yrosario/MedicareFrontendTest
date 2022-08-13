package admin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

import config.Base;
import webpages.AdminPage;
import webpages.EditProductPage;


public class AdminTest extends Base {
	
	private WebDriver webDriver;
	private final String baseURL;

	public AdminTest() throws Exception {
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
		 webDriver.get(baseURL+"/admin");
		
		
		AdminPage adminPage = new AdminPage(webDriver);
		
		String result = adminPage.getTitle().getText();
		AssertJUnit.assertEquals(result,"Manage Products");
	}
	
	@Test
	public void validateHeadersTest() {
		 webDriver.get(baseURL+"/admin");
		
		
		AdminPage adminPage = new AdminPage(webDriver);
		
		String result = adminPage.getHeader().getText();
		AssertJUnit.assertEquals(result,"ID Image Name Brand Category Quantity Price Edit Disable");
	}
	
	@Test
	public void validatePriceTest() {
		 webDriver.get(baseURL+"/admin");
		
		
		AdminPage adminPage = new AdminPage(webDriver);
		
		List<WebElement> prices= adminPage.getPrices();
		boolean result = true;
		
		for(WebElement ele : prices) {
			result = result & Float.parseFloat(ele.getText().substring(1)) > 0;
		}
		AssertJUnit.assertTrue(result);
	}
	
	@Test
	public void EditBtnTest() {
		 webDriver.get(baseURL + "/admin");
		
		
		AdminPage adminPage = new AdminPage(webDriver);
		
		WebElement btnEdit = adminPage.getEditBtn().get(0);
		
		btnEdit.click();
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
		
		String result = editProductPage.getTitle().getText();
		
		AssertJUnit.assertEquals(result, "Edit Product");
	}
	

	@AfterTest
	public void close() {
		webDriver.close();
	}
	
	

}
