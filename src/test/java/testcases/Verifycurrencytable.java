package testcases;

import java.util.List;

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

public class Verifycurrencytable 
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=Browserfactory.getbrowser("firefox");
		driver.get(Dataproviderfactory.getconfig().getapplicationurl());
	}
@Test
public void testcurrencytable() 
{
	
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	
	home.logintoapplication(Dataproviderfactory.getExcel().getdata(0, 0, 0),Dataproviderfactory.getExcel().getdata(0, 0, 1) );
	
List<WebElement> col=	driver.findElements(By.xpath("/html/body/div/div/main/div[3]/table/thead/tr/th"));
System.out.println(col.size());
WebElement rows=	driver.findElement(By.xpath("//table[@class='table table-striped table-sm']/tbody/tr"));
System.out.println(rows.getText());
	
}
@AfterMethod
public void teardown()
{
	Browserfactory.closebrowser(driver);
}
}
