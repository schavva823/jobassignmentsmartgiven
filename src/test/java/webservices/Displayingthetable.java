package webservices;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

public class Displayingthetable 
{
 @Test
	public void getdata()
 {
	 try {
		URL url = new URL("http://api.fixer.io/latest?base=GBP");
		 HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		 conn.setRequestMethod("GET"); 
		 conn.connect(); 
		 int responsecode = conn.getResponseCode(); 
		 if(responsecode != 200)
			 throw new RuntimeException();
			 else
			 {
				 Scanner sc = new Scanner(url.openStream());
				 String inline="";
				 while(sc.hasNext())
				 {
				 inline+=sc.nextLine();
				 }
				 System.out.println("\nJSON data in string format");
				 System.out.println(inline);
				 JSONParser parse = new JSONParser(); 
				 JSONObject jobj = (JSONObject)parse.parse(inline); 
				
				 sc.close();
			 }

	} 
	 
	 catch (Exception e) 
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
 }

}
