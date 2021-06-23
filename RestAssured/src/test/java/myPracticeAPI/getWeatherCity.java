package myPracticeAPI;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class getWeatherCity {

	@Test (enabled = false)
	public void getWeather()
	{
		// Specify Base URI
		RestAssured.baseURI="https://reqres.in";
		
		// Specify Request Object
		RequestSpecification httpRequst = RestAssured.given();
		
		// Specify Response Object
		Response response = httpRequst.request(Method.GET,"/api/users/2");
		
		String respBody = response.getBody().asPrettyString();
		
		System.out.println("Response Body is as :" + respBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code is :"+ statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
		
		
	}
	
	@Test (enabled = true)
	public void createUser()
	{
		// Specify Base URI
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification userRequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("name","Betal");
		requestParam.put("job", "leader");
		
		userRequest.header("Content-Type","application/json");
		userRequest.body(requestParam.toJSONString());
		
		Response userResp = userRequest.request(Method.POST,"/api/users");
		
		String completeResp = userResp.getBody().asString();
		System.out.println(completeResp);
		
		int statusCode = userResp.getStatusCode();
		System.out.println("Response code is returned as : "+statusCode);
		int id = userResp.jsonPath().getInt("id");
		System.out.println("ID is :" + id);
		// fetch Headers from response.
		
		String contentType = userResp.header("Content-Type");
		System.out.println("Content-Type is : "+contentType);
		
		Assert.assertEquals(contentType,"application/json; charset=utf-8");
		
		
		
		
		
		
		
		
	
		
		
		
		
				
				
				
		
		
		
	}
	
	
	
}
