package eCommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ecommerceRestTesting {
	
	public static String baseuri = "https://ecommerceservice.herokuapp.com";
	public static String accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MGNiMDFmNjZjMDg4NDAwMTdjMjdmNmMiLCJpYXQiOjE2MjM5MjAxODUsImV4cCI6MTYyNDAwNjU4NX0.WqlsznUD9j4zOzS7OePqiiAqwcpB35fr4tzzEgMtw1I";
	
	
	@Test (enabled = false)
	public void signUp()
	{
		RestAssured.baseURI = baseuri;
		
		String requestBody = "{\r\n" + 
				"	\"email\": \"nileshnehete101@gmail.com\",\r\n" + 
				"	\"password\": \"APItest@123\"\r\n" + 
				"}\r\n" + 
				"";
		
	  Response response = given()
	  .headers("Content-Type","application/json")
	  .body(requestBody)
	  
	  .when()
	  .post("/user/signup")
	  
	  .then()
	  .assertThat()
	  .statusCode(201)
	  .extract().response();
	  
	System.out.println("Response : " + response.asString());
	  
	}
	
	@Test (enabled = false)
	public void login()
	{
		RestAssured.baseURI = baseuri;
		
		String requestBody = "{\r\n" + 
				"	\"email\": \"nileshnehete101@gmail.com\",\r\n" + 
				"	\"password\": \"APItest@123\"\r\n" + 
				"}\r\n" + 
				"";
		
	  Response loginResponse = given()
	  .headers("Content-Type","application/json")
	  .body(requestBody)
	  
	  .when()
	  .post("/user/login")
	  
	  .then()
	  .assertThat()
	  .extract().response();
	  
	System.out.println("Response : " + loginResponse.asString());
	  
	String loginResp = loginResponse.asString();
	JsonPath jsonRespBody = new JsonPath(loginResp);
	accessToken = jsonRespBody.get("accessToken");
	System.out.println(accessToken);
	
	
	}
	
	@Test (priority = 2)
	public void getUsers()
	{
	  RestAssured.baseURI = baseuri;
	 // System.out.println(accessToken);
	  String token = "Bearer "+ accessToken;
	 // System.out.println(token);
	  
	  Response getusers = given()
	  .headers("Content-Type","application/json")
	  .headers("Authorization","Bearer "+ accessToken)
	  
	  .when()
	  .get("/user")
	  
	  .then()
	  .extract().response();
	  
	//System.out.println("Response : " + getusers.asString());
	  
	String usersList = getusers.asString();
	JsonPath usersRespBody = new JsonPath(usersList);
	
	int count = usersRespBody.getInt("count");
	
	for(int i=0;i<count;i++)
	{
		if (usersRespBody.get("users[i].email") == "nileshnehete101@gmail.com")
		{
			System.out.println("User "+usersRespBody.get("users[i].email")+" is placed at position "+ i);
		}
	}
	
	System.out.println(count);
	
	
	}

}
