package restassureddemoproject;

import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Script003JSONPayload {
	
	@Test
	public void PostUsingJSON() {
		
		
		JSONObject body = new JSONObject();
		
		body.put("name", "Kartik");
		body.put("job", "Developer");
		
		RestAssured
		
		.given()
		.baseUri("https://reqres.in/api/users/")
		.contentType(ContentType.JSON)
		.body(body.toString())
		.when().post()
		.then()
		.statusCode(201)
		.body("name", equalTo("Kartik"))
		.extract().path("id");		
					
		
	}

}
