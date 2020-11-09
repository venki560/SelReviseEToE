package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageObj {
	
	public WebDriver driver;
	public loginPageObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='user_email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id='user_password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement logIn;
	
	

}
