package PageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class uploadDownloadPage {
	
	public WebDriver driver;
	public uploadDownloadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(text(),'Choose Files')]")
	public WebElement chooseFile;
	
	@FindBy(xpath="//span[text()='Download']")
	public WebElement downloadFile;
	
	@FindBy(xpath="//iframe[@id='google_ads_iframe_/35673958/smallpdf_word_to_pdf_leaderboard_0']")
	public WebElement frameWin;
	
	@FindBy(xpath="//span[text()='wordFile-converted.pdf']")
	public WebElement downloadFileName;
	
	@FindBy(xpath="//span[contains(text(),'Download')]")
	public WebElement downloadBtn;
	
	public By downloadFileName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
