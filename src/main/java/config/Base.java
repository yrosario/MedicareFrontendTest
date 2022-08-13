package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	private WebDriver webDriver;

	
	public Base() throws Exception {
		this.initializerDriver();
	}


	@SuppressWarnings("deprecation")
	public void initializerDriver() throws Exception
	{
		Properties prop = new Properties();
		FileInputStream fileStream = new FileInputStream("src/main/resources/data.properties");
		
		prop.load(fileStream);
		String browserName = prop.getProperty("browser");
		String folderPath = prop.getProperty("folderPath");
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", folderPath + "/chromedriver");
			webDriver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", folderPath + "/firefoxdriver");
			webDriver = new FirefoxDriver();
		}else {
			throw new Exception("Web driver is null");
		}
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}


	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	
}
