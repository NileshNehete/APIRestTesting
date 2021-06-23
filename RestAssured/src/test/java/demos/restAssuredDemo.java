package demos;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class restAssuredDemo {

	public static String baseUri = "https://api.trello.com";
	
	@Test (enabled = false)
	public void testCase1()
	{
		RestAssured.baseURI = baseUri; // Base URI is loaded
		
		//given , when , and , then
		
		given()
		.param("key","043aa654f88902242c4efd23fb164bf4")
		.param("token","ec0ff1c14684ad60947adf084024a517648f17582a2511bdbd8d3a86d6626e33")
		.when()
		.get("/1/boards/60c85a399ea9d90991554a11")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("name",equalTo("{myBoard}"));
		System.out.println("Executed body successfully");
		
	}
	@Test (enabled = false)
	public void testCase2()
	{
		RestAssured.baseURI = baseUri; // Base URI is loaded
		
		//given , when , and , then
		
		given()
		.param("key","043aa654f88902242c4efd23fb164bf4")
		.param("token","ec0ff1c14684ad60947adf084024a517648f17582a2511bdbd8d3a86d6626e33")
		.when()
		.get("/1/boards/60c85a399ea9d90991554a11")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.header("Content-Type", "application/json; charset=utf-8");
	
		System.out.println("Executed header successfully");
		
	}
	
	@Test
	public void testCasePost()
	{
		RestAssured.baseURI = baseUri; // Base URI is loaded
		
		//given , when , and , then
		//post method without body
		String boardName = "RestAssuredBoard" + (int)(Math.random());
		
		given()
		.queryParam("key","043aa654f88902242c4efd23fb164bf4")
		.queryParam("token","ec0ff1c14684ad60947adf084024a517648f17582a2511bdbd8d3a86d6626e33")
		.queryParam("name", boardName)
		.headers("Content-Type","application/json")
		.when()
		.post("/1/boards/")
		.then()
		.statusCode(200);
			
		System.out.println("Executed successfully!! Board is created");
		
	}
	
	
}
