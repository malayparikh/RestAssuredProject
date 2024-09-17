package restassureddemoproject;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostMethod {
	
	@Test
	public void postMethodDemo() {
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("name", "Ram");
		map.put("job", "Teacher");
		
				
		 RestAssured
		.given().baseUri("https://reqres.in/")
		.basePath("api/users")
		.contentType("application/json")
		.body(map)
		.when().post()
		.then().statusCode(201).log().all();
		
			
		
	}
	
	

}
