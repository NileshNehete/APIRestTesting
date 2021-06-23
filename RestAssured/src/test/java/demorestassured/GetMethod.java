package demorestassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class GetMethod {

	public static String baseUri = "https://api.trello.com";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = baseUri; // value is assigned to restassured class

		given()
		.param("key","043aa654f88902242c4efd23fb164bf4")
		.param("token","ec0ff1c14684ad60947adf084024a517648f17582a2511bdbd8d3a86d6626e33")
		.when()
		.get("/1/boards/60c85a399ea9d90991554a11")
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.and()
		.body("name",equalTo("myBoard"));
		System.out.println("This is first RestAssured code and successful");
	}

}



//https://api.trello.com/1/boards/60c85a399ea9d90991554a11?key={{key}}&token={{token}}