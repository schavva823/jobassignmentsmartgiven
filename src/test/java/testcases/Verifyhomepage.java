package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicationpages.HomePage;
import factory.Browserfactory;
import factory.Dataproviderfactory;

public class Verifyhomepage 
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=Browserfactory.getbrowser("chrome");
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
	}
@Test
public void testhomepage()
{
	
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	String title=home.getapplicationtitle();
	Assert.assertTrue(title.contains("Dashboard Template for Bootstrap"));
	
	
}
@AfterMethod
public void teardown()
{
	Browserfactory.closebrowser(driver);
}
}
