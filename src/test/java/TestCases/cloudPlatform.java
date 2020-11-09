package TestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class cloudPlatform {
	
	@Test
	public void cloudChromeWindowPlatform() throws MalformedURLException
	{
		
		String Url="https://venki560:7710d2f2-7873-4b68-aeab-732cfb3aeb2c@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		
		MutableCapabilities sauceOptions = new MutableCapabilities();

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setExperimentalOption("w3c", true);
		browserOptions.setCapability("platformName", "Windows 8.1");
		browserOptions.setCapability("browserVersion", "86.0");
		browserOptions.setCapability("sauce:options", sauceOptions);
		WebDriver driver = new RemoteWebDriver(new URL(Url),browserOptions);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
	}

}
