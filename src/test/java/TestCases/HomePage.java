package TestCases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class HomePage extends base {
	homePageObj hp;
	public WebDriver driver;
	private static Logger log =LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException, InterruptedException
	{
		driver=initialize();
		driver.get(prop.getProperty("url"));
		log.info("url launched in successfully");
	}
	
	@Test
	public void homePagee()
	{
	driver.get(prop.getProperty("url"));
	hp=new homePageObj(driver);
	Assert.assertEquals("AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING",hp.title.getText());
	log.info("sign button is displayed");
	}
	
	@Test
	public void LoginDBParameters() throws SQLException
	{
		String localhost = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+localhost+":"+port+"/SelReviseDB", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from SelTable where user='Tester'");
		while(rs.next())
		{
		
		log.info("webPage launched successfully");
		driver.manage().window().maximize();
		homePageObj hp = new homePageObj(driver);
		loginPageObj lp = new loginPageObj(driver);
		Assert.assertTrue(hp.signIn.isDisplayed());
		log.info("sign button is displayed");
		hp.signIn.click();
		log.info("sign button is working properly");
		lp.email.sendKeys(rs.getString("user"));
		log.info("username is entered successfully");
		lp.password.sendKeys(rs.getString("password"));
		log.info("password is entered successfully");
		lp.logIn.click();
		log.info("login button is working properly");
		Assert.assertTrue(lp.logIn.isDisplayed());
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
