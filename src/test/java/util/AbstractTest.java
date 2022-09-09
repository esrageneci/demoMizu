package util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractTest  {
	
	protected static WebDriver driver;
	protected static Configuration configuration;
	
	
	
	public AbstractTest(){
	}
	
	@BeforeEach
	public  void openBrowserandWebsite(){
		configuration = new Configuration();
		System.setProperty("webdriver.chrome.driver", configuration.getChromeDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get(configuration.getPageURL());
	}
	
	
	@AfterEach
	public  void closeBrowser(){driver.quit();}
}
