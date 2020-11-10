package TestCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectRepo.autoITPage;
import PageObjectRepo.homePageObj;
import PageObjectRepo.loginPageObj;
import resources.base;

public class homePageNavigation extends base {
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(homePageNavigation.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver = initialize();
		driver.get(prop.getProperty("url"));
		log.info("url launced successfully");
	}
	
	
	@Test
	public void navigation()
	{
		driver.get(prop.getProperty("url"));
		homePageObj hp = new homePageObj(driver);
		hp.getLink.click();
		Assert.assertTrue(hp.getLink.isDisplayed());
		log.info("link is displayed");
				
	}
	
	@Test
	public void autoIT() throws InterruptedException
	{
		autoITPage aIT = new autoITPage(driver);
		driver.get(prop.getProperty("urlAutoIT"));
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		log.info("the-internet.herokuapp.com logged in Successfully");
		aIT.authBrowser.click();
		System.out.println(aIT.authText.getText());
		Assert.assertEquals(aIT.authText.getText(), "Congratulations! You must have the proper credentials.");
		log.info("enter windows autho correctly");
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
