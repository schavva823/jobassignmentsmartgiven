package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicationpages.HomePage;
import factory.Browserfactory;
import factory.Dataproviderfactory;

public class Verifyloginpage 
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=Browserfactory.getbrowser("firefox");
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
	}
@Test
public void testloginpage() throws InterruptedException
{
	
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	String title=home.getapplicationtitle();
	Assert.assertTrue(title.contains("Dashboard Template for Bootstrap"));

home.logintoapplication(Dataproviderfactory.getExcel().getdata(0, 0, 0),Dataproviderfactory.getExcel().getdata(0, 0, 1) );
	String url=driver.getCurrentUrl();
	System.out.println(url);
	Assert.assertTrue(url.contains("dashboard.html"));
	
	
}
@AfterMethod
public void teardown()
{
	Browserfactory.closebrowser(driver);
}
}
