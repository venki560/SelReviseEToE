package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePageObj {
public WebDriver driver;
	public homePageObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	public WebElement signIn;
	
	@FindBy(xpath="//h3[contains(text(),'An Academy to learn Everything about Testing')]")
	public WebElement title;
	
	@FindBy(xpath="//a[contains(text(),'Selenium Webdriver with Java Basics + Advanced + Interview Guide')]")
	public WebElement getLink;

}
