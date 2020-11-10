package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectRepo.uploadDownloadPage;
import resources.base;

public class autoITUploadDownload extends base {

	private static Logger log =LogManager.getLogger(autoITUploadDownload.class.getName());
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initialize();
		driver.get(prop.getProperty("autoURL"));
		log.info("WordToPdf convert url loaded successfully");
		
	}
	
	
	@Test
	public void uploadDownloadAutoIt() throws IOException, InterruptedException
	{
		
		uploadDownloadPage uDPage = new uploadDownloadPage(driver);
		uDPage.chooseFile.click();
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoItScript1.exe");
		Thread.sleep(10000);
		System.out.println(uDPage.downloadFileName.getText());;
		uDPage.downloadBtn.click();
		Thread.sleep(10000);
		File fil = new File(download+"/wordFile-converted.pdf");
		if(fil.exists())
		{
			Assert.assertTrue(fil.exists());
			if(fil.delete())
			System.out.println("file deleted");
		}
		else {
			System.out.println("File not downloaded");
		}
		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("WordToPdf convert url closed successfully");
	}
	
}

