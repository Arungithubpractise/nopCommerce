package stepDefinitions;		

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.Addcustomerpage;
import pageObjects.Adddiscount;
import pageObjects.LoginPage;
import pageObjects.checkingorders;


public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public Addcustomerpage addcust;
	public Adddiscount adddis;
	
	public static Logger logger;
	public Properties configProp;
	public checkingorders orders;
	
	
	

	public String getPageTitle() {
		return driver.getTitle();

	}

	public static String randomString() {
		String generateString1 = RandomStringUtils.randomAlphabetic(5);
		return (generateString1);
	}

}