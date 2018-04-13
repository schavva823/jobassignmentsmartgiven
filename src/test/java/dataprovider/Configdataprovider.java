package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configdataprovider 
{
	Properties pro;
	public Configdataprovider()
	{
		File src=new File("./Configuration/config.properties");
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} 
		catch (Exception e) 
		{
			System.out.println("exception is:"+e.getMessage());
		}
	}
	
	public String getapplicationurl()
	{
	String url=	pro.getProperty("url");
	return url;
	}
	public String getchromepath()
	{
	String url=	pro.getProperty("chromepath");
	return url;
	}
	public String getIEpath()
	{
	String url=	pro.getProperty("IEpath");
	return url;
	}
	public String getFirefoxpath()
	{
	String url=	pro.getProperty("firefoxpath");
	return url;
	}
	
}
