package shop;

import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import config.Base;
import webpages.LoginPage;
import webpages.ShopPage;


public class ShopTest extends Base {
	
	private WebDriver webDriver;

	public ShopTest() throws Exception {
		super();
		super.initializerDriver();
		webDriver = super.getWebDriver();
		
	}

	@Test
	public void validatePageTitleTest() {
		 webDriver.get("http://localhost:4200/shop");
		
		
		ShopPage shopPage = new ShopPage(webDriver);
		
		String result = shopPage.getTitle().getText();
		Assert.assertEquals(result,"Most Viewed Items");
	}
	
	@Test
	public void productListTest() {
		 webDriver.get("http://localhost:4200/shop");
		
		
		ShopPage shopPage = new ShopPage(webDriver);
		
		List<WebElement> products = shopPage.getProductsList();
		
		Assert.assertTrue(products.size() > 0);

	}
	
	@Test
	public void buttonTest() {
		 webDriver.get("http://localhost:4200/shop");
		
		
		ShopPage shopPage = new ShopPage(webDriver);
		
		List<WebElement> products = shopPage.getProductsList();
		
		boolean result = true;
		for(WebElement ele: products) {
			result = result && ele.findElement(By.id("prod-cart-btn")).isDisplayed();
		}
		
		Assert.assertTrue(result);

	}
	
	@Test
	public void buttonNotLoginTest() {
		 webDriver.get("http://localhost:4200/shop");
		
		
		ShopPage shopPage = new ShopPage(webDriver);
		
		List<WebElement> products = shopPage.getProductsList();
		
		
		WebElement btn = products.get(0).findElement(By.id("prod-cart-btn"));
		btn.click();
		
		LoginPage loginPage = new LoginPage(webDriver);
		String result = loginPage.getTitle().getText();
		
		Assert.assertEquals(result,"Login");

	}
	
	@Test
	public void prodBuyBtnNotLoginTest() {
		 webDriver.get("http://localhost:4200/shop");
		
		
		ShopPage shopPage = new ShopPage(webDriver);
		
		List<WebElement> products = shopPage.getProductsList();
		
		
		WebElement btn = products.get(0).findElement(By.id("product-buy-btn"));
		btn.click();
		
		LoginPage loginPage = new LoginPage(webDriver);
		String result = loginPage.getTitle().getText();
		
		Assert.assertEquals(result,"Login");

	}
	
	
	@Test
	public void searchTest() {
		webDriver.get("http://localhost:4200/shop");
		
		ShopPage shopPage = new ShopPage(webDriver);
		
		
		String searchTerm = "Tylenol";
		shopPage.getSearchBar().sendKeys(searchTerm);
		shopPage.getSearchBtn().click();
		
		List<WebElement> products = shopPage.getProductsList();
		
		//Checks product title of all products return and makes sure
		//that the search term is include in the title
		Pattern pattern = Pattern.compile(searchTerm);
		boolean result = true;
		for(WebElement ele: products) {
			String prodTitle = ele.findElement(By.id("prod-title")).getText();
			Matcher matcher = pattern.matcher(prodTitle);
			result = result && matcher.find();
		}
		
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void categoryTest() {
		webDriver.get("http://localhost:4200/shop");
		
		ShopPage shopPage = new ShopPage(webDriver);
		
		
		
		//Test clicks on each category filter goes thru each element and tests if the category
		//clicked matched the products that listed
		List<WebElement> categories = shopPage.getCategory();
	
		boolean result = true;
		for(WebElement ele : categories) {
			String searchTerm = ele.getText();
			ele.click();
			List<WebElement> products = shopPage.getProductsList();
			for(WebElement proEle: products) {
				String categoryStr = proEle.findElement(By.id("prod-category")).getText();
				result = result && searchTerm.equals(categoryStr);
			}
		}
		
		Assert.assertTrue(result);
		
	}
	
	

	@AfterTest
	public void close() {
		webDriver.close();
	}
	
	

}
