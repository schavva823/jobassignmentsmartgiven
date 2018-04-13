package webservices;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class Verifythewebservice 
{
	@Test
	public void responsecode()
	{
	Response resp=	RestAssured.get("http://api.fixer.io/latest?base=GBP");
	int code=resp.statusCode();
	System.out.println("the status code is "+ code);
	Assert.assertEquals(code,200);
	}
	@Test
	public void getdata()
	{
	Response resp=	RestAssured.get("http://api.fixer.io/latest?base=GBP");
	String data=resp.asString();
	System.out.println("data is"+data);
	}
}
