package PageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class autoITPage {

	public WebDriver driver;
	public autoITPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/basic_auth']")
	public WebElement authBrowser;
	
	@FindBy(xpath="//p[contains(text(),'Congratulations')]")
	public WebElement authText;
}
