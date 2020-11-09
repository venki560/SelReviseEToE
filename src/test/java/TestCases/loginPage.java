package TestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectRepo.homePageObj;
import PageObjectRepo.loginPageObj;
import resources.base;

public class loginPage extends base {
	
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(loginPage.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException
	{
		driver = initialize();
		log.info("driver initialized successfully");
		
	}
	
	@Test(dataProvider="getData")
	public void loginPagee(String username, String password)
	{
		driver.get(prop.getProperty("url"));
		log.info("webPage launched successfully");
		driver.manage().window().maximize();
		homePageObj hp = new homePageObj(driver);
		loginPageObj lp = new loginPageObj(driver);
		Assert.assertTrue(hp.signIn.isDisplayed());
		log.info("sign button is displayed");
		hp.signIn.click();
		log.info("sign button is working properly");
		lp.email.sendKeys(username);
		log.info("username is entered successfully");
		lp.password.sendKeys(password);
		log.info("password is entered successfully");
		lp.logIn.click();
		log.info("login button is working properly");
		Assert.assertTrue(lp.logIn.isDisplayed());
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="adminOne";
		data[0][1]="passwordOne";
		data[1][0]="adminTwo";
		data[1][1]="passwordTwo";
		return data;
	}

}
