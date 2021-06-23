package myPracticeAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class test {

 	
   @Test
   public void testMethod()
   {
	   
	 RestAssured.baseURI = "https://reqres.in";//https://reqres.in/api/users/2  
	 
	 RequestSpecification request = RestAssured.given();
	 
	 Response response = request.request(Method.GET, "/api/users/2");
	 
	 String respBody = response.getBody().asPrettyString();
	 
	 System.out.println(respBody);
	 
	   
   }
	
}
