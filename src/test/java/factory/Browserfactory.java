package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataprovider.Configdataprovider;

public class Browserfactory 
{
	static WebDriver driver;
	public static WebDriver getbrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("firefox"))
		{

			
			System.setProperty("webdriver.gecko.driver", Dataproviderfactory.getconfig().getFirefoxpath());
			driver=new FirefoxDriver();
			
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			
			
			System.setProperty("webdriver.chrome.driver",Dataproviderfactory.getconfig().getchromepath());
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("ie"))
		{
         
			
			System.setProperty("webdriver.ie.driver", Dataproviderfactory.getconfig().getIEpath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
public static void closebrowser(WebDriver ldriver)
{
	ldriver.quit();
}
}
