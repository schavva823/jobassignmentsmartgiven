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

public class Verifyloginpagewithreports 
{
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeMethod
	public void setup()
	{
		report =new ExtentReports("./Reports/loginpagereport.html",true);
		logger=report.startTest("verify loginpage");
		driver=Browserfactory.getbrowser("firefox");
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
		logger.log(LogStatus.INFO, "application up and running");
	}
@Test
public void testloginpage() throws InterruptedException
{
	
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	String title=home.getapplicationtitle();
	Assert.assertTrue(title.contains("Dashboard Template for Bootstrap"));
	logger.log(LogStatus.PASS, "successfully verified");
	logger.log(LogStatus.INFO, "user is entering valid credentials");

	home.logintoapplication(Dataproviderfactory.getExcel().getdata(0, 0, 0),Dataproviderfactory.getExcel().getdata(0, 0, 1) );
	String url=driver.getCurrentUrl();
	System.out.println(url);
	Assert.assertTrue(url.contains("dashboard.html"));
	logger.log(LogStatus.PASS, "login functionality successfully verified");
	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.capturescreenshot(driver,"validation 2 screen")));
	
	
}
@AfterMethod
public void teardown()
{
	Browserfactory.closebrowser(driver);
	report.endTest(logger);
	report.flush();
}
}
