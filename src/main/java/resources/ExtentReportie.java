package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportie {
	
	static ExtentReports extent;
	public static ExtentReports getExtentReport()
	{
		String path = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Venkatesh");
		reporter.config().setDocumentTitle("SeleniumReviseReport");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Venki", "Tester");
		return extent;
	}

}
