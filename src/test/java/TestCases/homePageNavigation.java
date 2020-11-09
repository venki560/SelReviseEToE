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
		homePageObj hp = new homePageObj(driver);
		hp.getLink.click();
		Assert.assertTrue(hp.getLink.isDisplayed());
		log.info("link is displayed");
		System.out.println("Check GitHub");
		System.out.println("Check GitHub");
				
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
