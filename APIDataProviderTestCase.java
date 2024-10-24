package restassureddemoproject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIDataProviderTestCase {
	
	@DataProvider(name = "userData")
	public Object[][] createUserData() {
		
		return new Object[][] {
			
			{"Ram","Teacher"},
			{"Sita","Engineer"},
			{"Kartik","Software Engineer"},
			{"Ravana", "Project Manager"},
			{"Hanuman","QA Engineer"}
			
		};
	}
	
	@Test(dataProvider="userData")
	public void testcaseCreateUser(String name, String job) {
		
		RestAssured.baseURI="https://reqres.in/api/";
		
		given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \""+name+ "\",\r\n"
				+ "    \"job\": \""+job+ "\"\r\n"
				+ "}")
		.when().post("/users")
		.then()
		.statusCode(201); //Verify the status code with 201		
		
			
	}
	
}
