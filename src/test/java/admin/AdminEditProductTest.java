package admin;

import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import config.Base;
import webpages.EditProductPage;


public class AdminEditProductTest extends Base {
	
	private WebDriver webDriver;

	public AdminEditProductTest() throws Exception {
		super();
		super.initializerDriver();
		webDriver = super.getWebDriver();
		
	}

	@Test
	public void validatePageTitleTest() {
		 webDriver.get("http://localhost:4200/admin/manage-products/edit-product/1");
		
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
		
		String result = editProductPage.getTitle().getText();
		Assert.assertEquals(result,"Edit Product");
	}
	
	@Test
	public void testProductId() {
		 webDriver.get("http://localhost:4200/admin/manage-products/edit-product/1");
		
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
		
		String result = editProductPage.getId().getText();
		Assert.assertEquals(result,"ID 1");
	}
	
	
	@Test
	public void validateSuccessMessageTest() {
		 webDriver.get("http://localhost:4200/admin/manage-products/edit-product/1");
		
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
	
		editProductPage.getUpdateBtn().click();

		String result = editProductPage.getUpdateSuccessMsg().getText();
		Assert.assertEquals(result,"Product was saved successfully! Go Product Admin Page");
	}
	
	
	@Test
	public void validateFormTest() {
		 webDriver.get("http://localhost:4200/admin/manage-products/edit-product/1");
		
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
		
		editProductPage.getName().clear();
		editProductPage.getName().sendKeys("");
		editProductPage.getBrand().sendKeys("");
		editProductPage.getPrice().sendKeys("");
		
		boolean result = editProductPage.getUpdateBtn().isEnabled();
		Assert.assertEquals(result,true);
	}
	

	
	


	@AfterTest
	public void close() {
		webDriver.close();
	}
	
	

}
