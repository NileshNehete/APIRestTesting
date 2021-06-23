package employee;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.List;
public class validatemployee {
	
	public static String baseUri = "http://dummy.restapiexample.com";
	
	
	@Test
	public void createEmployee()
	{
		RestAssured.baseURI = baseUri;
		
		String reqBody =  "{\r\n" + 
		"	\"name\": \"nileshnehete\",\r\n" + 
		"	\"salary\": \"12550\"\r\n" + 
		"\r\n" + 
		"	\"age\": \"12550\"\r\n" + 
		"}\r\n" + 
		"";
		
	     		
		Response response = given()
		.headers("Content-Type","application/json")
		.body(reqBody)
		
		.when()
		.post("/api/v1/create")
		
		.then()
		.assertThat()
		.statusCode(200)
		
		.extract().response();
		
		System.out.println(response.asString());
		
		String creteEmplyeeResponse = response.asString();
		
		JsonPath createEmpJson = new JsonPath(creteEmplyeeResponse);
		
		String status = createEmpJson.get("status");
		
		List<String> empData = createEmpJson.get("data");

		System.out.println("Status is :"+ empData);
		
		
		
	}
	
	

}
