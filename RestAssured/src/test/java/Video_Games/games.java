package Video_Games;

import org.testng.annotations.Test;

import demos.restAssuredDemo;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.Random;


public class games {
	
	static String endpoint = "http://localhost:8080";
	Random dice = new Random();
	int videoId = dice.nextInt(100)+10;
		
	//@Test (priority = 1)
	public void getGames()
	{
		
		RestAssured.baseURI = "http://localhost:8080"; //http://localhost:8080/app/videogames
		
		RequestSpecification getGames = RestAssured.given();
		
		Response getGamesResponse = getGames.request(Method.GET,"/app/videogames");
		
		String temp = getGamesResponse.getBody().asPrettyString();
		
		int statusCode = getGamesResponse.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		String contentType = getGamesResponse.header("content-type");
		//Assert.assertEquals(contentType, "application/xml");
		
		System.out.println(contentType);
		//System.out.println("Games List is : "+ temp);
		
				
	}
	
	@Test 
	public void test_getGames()
	{
		
		RestAssured.baseURI = endpoint;
		
		Response rsp=given()
		
		.headers("Content-Type","application/json")
		.when()
		  .get("/app/videogames")
		  
		.then()
		  .statusCode(200)
		  .contentType("application/xml")
		  .extract().response();
	
		System.out.println(rsp.asPrettyString());
	}	
	
	//@Test 
	public void test_addGame()
	{
		
		RestAssured.baseURI = endpoint;
		
		String gameVal = "{\r\n" + 
				"				  \"id\": 20,\r\n" + 
				"				  \"name\": \"Godzilla\",\r\n" + 
				"				  \"releaseDate\": \"2021-06-20T12:29:43.344Z\",\r\n" + 
				"				  \"reviewScore\": 100,\r\n" + 
				"				  \"category\": \"cartoon\",\r\n" + 
				"				  \"rating\": \"3\"\r\n" + 
				"				}";
		
		Response resp = given()
		.contentType("application/json")
		.body(gameVal)
		.when()
		.post("/app/videogames")
		
		.then()
		.log().body() // to display body
		.extract().response();
		
		String temp = resp.getBody().asPrettyString();
		//System.out.println(temp);
		
		Assert.assertEquals(temp.contains("Record Added Successfully"), true);
        	
	}	
	

	//@Test (enabled = true )
	public void test_SearchGame()
	{
		
		RestAssured.baseURI = endpoint;
		
//		RequestSpecification searchRequest = RestAssured.given();
//		Response Resp = searchRequest.request(Method.DELETE,"/app/videogames/20");
//		
//		String deleteResp = Resp.getBody().asPrettyString();
		
		given()
		
		.when()
		.get("/app/videogames/20")
		
		.then()
		.log().body()
		 .body("videoGame.id", equalTo("20"))
		 .body("videoGame.name", equalTo("Godzilla"));	
		
		
	}
	
	@Test (enabled = false)
	public void test_deleteGame()
	{
		
		RestAssured.baseURI = endpoint;
		
		RequestSpecification deleteRequest = RestAssured.given();
		Response Resp = deleteRequest.request(Method.DELETE,"/app/videogames/15");
		
		String deleteResp = Resp.getBody().asPrettyString();
		
	}
	
	

}
