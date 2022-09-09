package util;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	
	private Properties configProps= new Properties();
	private String chromeDriverPath;
	private String loginPageURL;
	private String homePageURL;
	private String validEmail;
	private String invalidEmail;
	private String validPassword;
	private String signInAllertMessage;
	private String invalidPasswordShort;
	private String invalidPasswordLong;
	private String invalidPassword;

	public Configuration(){
		
		try {
			String configFile = "config.properties";
			configProps.load(ClassLoader.getSystemResourceAsStream(configFile));
			configProps.load(ClassLoader.getSystemResourceAsStream(configFile));
			
			this.chromeDriverPath = configProps.getProperty("webdriver.chrome.driver");
			this.loginPageURL = configProps.getProperty("loginPageURL");
			this.homePageURL = configProps.getProperty("homePageURL");
			this.validEmail = configProps.getProperty("validEmail");
			this.invalidEmail = configProps.getProperty("invalidEmail");
			this.invalidPassword = configProps.getProperty("invalidPassword");
			this.validPassword = configProps.getProperty("validPassword");
			this.signInAllertMessage = configProps.getProperty("signInAllertMessage");
			this.invalidPasswordShort = configProps.getProperty("invalidPasswordShort");
			this.invalidPasswordLong = configProps.getProperty("invalidPasswordLong");
			this.invalidPassword = configProps.getProperty("invalidPassword");
			
			
		}
		catch (IOException e) {
			System.err.println("Cannot read util.Configuration file");
		}
		
	}
	public String getChromeDriverPath() {
		return chromeDriverPath;}
	
	public String getLoginPageURL() {
		return loginPageURL;
	}
	public String getHomePageURL() {return homePageURL;}
	public String getValidEmail(){return validEmail;}
	public String getInvalidEmail(){return invalidEmail;}
	public String getValidPassword(){return validPassword;}
	public String getSignInAllertMessage(){return signInAllertMessage;}
	public String getInvalidPasswordShort(){return invalidPasswordShort;}
	public String getInvalidPasswordLong(){return invalidPasswordLong;}
	public String getInvalidPassword(){return invalidPassword;}
	
	
	
	
}//class
