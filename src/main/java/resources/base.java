package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {
	
	public WebDriver driver;
	public Properties prop;
	public String download;
	public WebDriver initialize() throws IOException
	{
	
		download = System.getProperty("user.dir");
		HashMap<String,Object> perfsOpt = new HashMap<String, Object>();
		perfsOpt.put("profile.default_content_settings.popups", 0);
		perfsOpt.put("download.default_directory", download);
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	//	String browserName=prop.getProperty("Browser");
		String browserName=System.getProperty("Browser");
		if(browserName.contains("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver86.exe");	
		ChromeOptions option= new ChromeOptions();
		option.setExperimentalOption("prefs", perfsOpt);
		if(browserName.contains("headless"))
		{
		option.addArguments("headless");
		}
		driver = new ChromeDriver(option);	
		}
		else if(browserName.contains("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");	
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		return driver;
	}
	
	public String getScreenShot(String TestMethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot sT=(TakesScreenshot)driver;
		File source = sT.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\report\\"+TestMethodName+".png";
		FileUtils.copyFile(source, new File(dest));
		return dest;
	}
	
	
	}
	
	
	


