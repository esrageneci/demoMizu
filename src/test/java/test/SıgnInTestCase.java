package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.AbstractTest;


public class SıgnInTestCase extends AbstractTest {
	
	@BeforeEach
	public void test(){
		
		driver.get(configuration.getLoginPageURL());
		
	}
	
	@Test
	public void SuccessfulSignIn() throws InterruptedException{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.findElement(By.id("EmailLogin")).sendKeys(configuration.getValidEmail());
		driver.findElement(By.id("Password")).sendKeys(configuration.getValidPassword());
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@style='display: block;']")));
		driver.findElement(By.xpath("//div[@style='display: block;']")).click();
		Assertions.assertEquals(configuration.getHomePageURL(),driver.getCurrentUrl());
		
	}
	
	@Test
	public void passwordisVisible(){
		driver.findElement(By.xpath("//span[@class='form-group__show-type js-show-type icon-eye']")).click();
		WebElement passwordBox= driver.findElement(By.id("Password"));
		Assertions.assertEquals("text",passwordBox.getAttribute("type"));
}
	
	@Test
	public void passwordisInvsible(){
		
		WebElement passwordBox= driver.findElement(By.id("Password"));
		Assertions.assertEquals("password",passwordBox.getAttribute("type"));
	}
	
	@Test
	public void unsuccessfulSignInviaInvalidEmail () {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.findElement(By.id("EmailLogin")).sendKeys(configuration.getInvalidEmail());
		driver.findElement(By.id("Password")).sendKeys(configuration.getValidPassword());
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'modal-content')]")));
		Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'modal-body') and text()='"+configuration.getSignInAllertMessage()+"']")).isDisplayed());
		
	}
	
	@Test
	public void unsuccessfulSignInviaInvalidShortPassword() {
		driver.findElement(By.id("EmailLogin")).sendKeys(configuration.getValidEmail());
		driver.findElement(By.id("Password")).sendKeys(configuration.getInvalidPasswordShort());
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Assertions.assertTrue(driver.findElement(By.id("Password-error")).isDisplayed());
	}
	
	@Test
	public void unsuccessfulSignInviaInvalidLongPassword() {
		driver.findElement(By.id("EmailLogin")).sendKeys(configuration.getValidEmail());
		driver.findElement(By.id("Password")).sendKeys(configuration.getInvalidPasswordLong());
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Assertions.assertTrue(driver.findElement(By.id("Password-error")).isDisplayed());
	}
	@Test
	public void unsuccessfulSignInviaInvalidEmailandPassword () {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.findElement(By.id("EmailLogin")).sendKeys(configuration.getInvalidEmail());
		driver.findElement(By.id("Password")).sendKeys(configuration.getInvalidPassword());
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'modal-content')]")));
		Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'modal-body') and text()='"+configuration.getSignInAllertMessage()+"']")).isDisplayed());
		
	}
	
	@Test
	public void unsuccessfulSignInviaEmptyEmailAddress () {
		driver.findElement(By.id("Password")).sendKeys(configuration.getValidPassword());
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Assertions.assertTrue(driver.findElement(By.id("EmailLogin-error")).isDisplayed());
	}
	@Test
	public void unsuccessfulSignInviaEmptyPassword () {
		driver.findElement(By.id("EmailLogin")).sendKeys(configuration.getValidEmail());
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Assertions.assertTrue(driver.findElement(By.id("Password-error")).isDisplayed());
	}
	@Test
	public void unsuccessfulSignInviaEmpty () {
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Assertions.assertTrue(driver.findElement(By.id("Password-error")).isDisplayed());
		Assertions.assertTrue(driver.findElement(By.id("EmailLogin-error")).isDisplayed());
	}
	
	@Test
	public void checkForgetPasswordButton () {
		driver.findElement(By.xpath("//a[@class='login__forgot-password js-forgot-password']")).click();
		Assertions.assertTrue(driver.findElement(By.id("Mail")).isDisplayed());
		
	}
	@Test
	public void successfulUseForgetPasswordButton () {
		driver.findElement(By.xpath("//a[@class='login__forgot-password js-forgot-password']")).click();
		Assertions.assertTrue(driver.findElement(By.id("Mail")).isDisplayed());
		driver.findElement(By.id("Mail")).sendKeys(configuration.getValidEmail());
		driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();
		Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='password-recovery-result js-password-recovery-result is-hidden is-visible']")).isDisplayed());

		
		
	}
}