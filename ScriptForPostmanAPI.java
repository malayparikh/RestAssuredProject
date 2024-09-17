package restassureddemoproject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ScriptForPostmanAPI {
	
	@Test(priority=1)
	public void postmanGetRequest()
	{
		String PMAPIKey = "PMAK-66e";
		
		RestAssured
		.given().baseUri("https://api.postman.com").basePath("/workspaces")
		.header("X-API-Key",PMAPIKey )
		.when().get()
		.then().statusCode(200).log().all();
		
		
	}
	@Test(priority=2)
	public void extractValueFromJson() {
		
		String PMAPIKey = "PMAK";
		
		RestAssured
		.given().baseUri("https://api.postman.com").basePath("/workspaces")
		.header("X-API-Key",PMAPIKey )
		.when().get()
		.then().log().all()
		.extract().path("workspaces[0].name");	
		
		
	}
	@Test(priority=3)
	public void extractDemoTest() {
		
		
		String PMAPIKey = "PMAK-66";
		String responseoutput=given().baseUri("https://api.postman.com").basePath("/workspaces")
				.header("x-api-key",PMAPIKey ).when().get()
				.then()
				.extract().path("workspaces[0].name");
		
		System.out.println("The name of the extracted path is : " + responseoutput);
		
		
	}

}
