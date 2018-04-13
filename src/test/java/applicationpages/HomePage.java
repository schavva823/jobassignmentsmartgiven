package applicationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	@FindBy(css="input[placeholder='username'][type='text']") WebElement username;
	@FindBy(css="input[placeholder='password'][type='password']") WebElement password;
	
	
	@FindBy(xpath="//input[@type='submit']") WebElement submit;
	@FindBy(xpath="//a[@href='#']") WebElement signoutlink;
	
			@FindBy(xpath="/html/body/div/div/main/div[3]") WebElement todayrates;
	
	
	public void logintoapplication(String uname,String pword)
	{
		username.sendKeys(uname);
		password.sendKeys(pword);
		submit.click();
	}
	public String getlinktext() 
	{
		String txt=todayrates.getText();
		return txt;
	}
	public String getapplicationtitle()
	{
		return driver.getTitle();
	}
	
}
