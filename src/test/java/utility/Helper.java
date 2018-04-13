package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper 
{
	public static String capturescreenshot(WebDriver driver,String screenshotname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String destination="C:\\jobassignmentsmart\\com.jobassignment.hybrid\\Screenshots\\"+screenshotname+System.currentTimeMillis()+".png";
try {
FileUtils.copyFile(src, new File(destination));
} catch (Exception e) {
	// TODO Auto-generated catch block
	System.out.println("failure to capture screenshot"+e.getMessage());
}
return destination;
	}
	

}
