package admin;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import config.Base;
import webpages.EditProductPage;


public class AdminEditProductTest extends Base {
	
	private WebDriver webDriver;
	private final String baseURL;

	public AdminEditProductTest() throws Exception {
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
		 webDriver.get(baseURL + "/admin/manage-products/edit-product/1");
		
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
		
		String result = editProductPage.getTitle().getText();
		AssertJUnit.assertEquals(result,"Edit Product");
	}
	
	@Test
	public void testProductId() {
		 webDriver.get(baseURL+"/admin/manage-products/edit-product/1");
		
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
		
		String result = editProductPage.getId().getText();
		AssertJUnit.assertEquals(result,"ID 1");
	}
	
	
	@Test
	public void validateSuccessMessageTest() {
		 webDriver.get(baseURL+"/admin/manage-products/edit-product/1");
		
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
	
		editProductPage.getUpdateBtn().click();

		String result = editProductPage.getUpdateSuccessMsg().getText();
		AssertJUnit.assertEquals(result,"Product was saved successfully! Go Product Admin Page");
	}
	
	
	@Test
	public void validateFormTest() {
		 webDriver.get(baseURL+"/admin/manage-products/edit-product/1");
		
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
		
		editProductPage.getName().clear();
		editProductPage.getName().sendKeys("");
		editProductPage.getBrand().sendKeys("");
		editProductPage.getPrice().sendKeys("");
		
		boolean result = editProductPage.getUpdateBtn().isEnabled();
		AssertJUnit.assertEquals(result,true);
	}
	

	
	


	@AfterTest
	public void close() {
		webDriver.close();
	}
	
	

}
