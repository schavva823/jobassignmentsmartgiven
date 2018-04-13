package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationpages.HomePage;
import factory.Browserfactory;
import factory.Dataproviderfactory;
import utility.Helper;

public class Verifyhomepagewithreports 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeMethod
	public void setup()
	{
		report =new ExtentReports("./Reports/homepagereport.html",true);
		//logger=new ExtentTest("verifying homepage","this page will verify title");
		logger=report.startTest("verify homepage");
		driver=Browserfactory.getbrowser("chrome");
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
		logger.log(LogStatus.INFO, "application up and running");
	}
@Test
public void testhomepage()
{
	
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	String title=home.getapplicationtitle();
	Assert.assertTrue(title.contains("Dashboard Template for Bootstrap"));
	//Helper.capturescreenshot(driver,"homepage");
	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.capturescreenshot(driver,"validation 1 screen")));
	logger.log(LogStatus.PASS, "successfully verified");
	
	
}
@AfterMethod
public void teardown()
{
	Browserfactory.closebrowser(driver);
	report.endTest(logger);
	report.flush();
}
}
