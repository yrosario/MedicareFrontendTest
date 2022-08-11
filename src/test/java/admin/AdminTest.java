package admin;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import config.Base;
import webpages.AdminPage;
import webpages.EditProductPage;


public class AdminTest extends Base {
	
	private WebDriver webDriver;

	public AdminTest() throws Exception {
		super();
		super.initializerDriver();
		webDriver = super.getWebDriver();
		
	}

	@Test
	public void validatePageTitleTest() {
		 webDriver.get("http://localhost:4200/admin");
		
		
		AdminPage adminPage = new AdminPage(webDriver);
		
		String result = adminPage.getTitle().getText();
		Assert.assertEquals(result,"Manage Products");
	}
	
	@Test
	public void validateHeadersTest() {
		 webDriver.get("http://localhost:4200/admin");
		
		
		AdminPage adminPage = new AdminPage(webDriver);
		
		String result = adminPage.getHeader().getText();
		Assert.assertEquals(result,"ID Image Name Brand Category Quantity Price Edit Disable");
	}
	
	@Test
	public void validatePriceTest() {
		 webDriver.get("http://localhost:4200/admin");
		
		
		AdminPage adminPage = new AdminPage(webDriver);
		
		List<WebElement> prices= adminPage.getPrices();
		boolean result = true;
		
		for(WebElement ele : prices) {
			result = result & Float.parseFloat(ele.getText().substring(1)) > 0;
		}
		Assert.assertTrue(result);
	}
	
	@Test
	public void EditBtnTest() {
		 webDriver.get("http://localhost:4200/admin");
		
		
		AdminPage adminPage = new AdminPage(webDriver);
		
		WebElement btnEdit = adminPage.getEditBtn().get(0);
		
		btnEdit.click();
		
		EditProductPage editProductPage = new EditProductPage(webDriver);
		
		String result = editProductPage.getTitle().getText();
		
		Assert.assertEquals(result, "Edit Product");
	}
	

	@AfterTest
	public void close() {
		webDriver.close();
	}
	
	

}
