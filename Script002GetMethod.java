package restassureddemoproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script002GetMethod {

	@Test(enabled=false)
	public void httpGetMethod() {

		Response res = RestAssured.get("https://reqres.in/api/users?page=1");

		System.out.println(res.getStatusCode());

		System.out.println(res.getBody().asString());

		System.out.println(res.getTime());

		System.out.println(res.getHeader("Content-Type"));
		System.out.println(res.getHeader("Cache-Control"));

		int expectedStatusCode = 200;
		int ActualStatusCode = res.getStatusCode();

		Assert.assertEquals(expectedStatusCode, ActualStatusCode);
	}
	
	@Test
	public void GetMethodBDD() {
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/api/users")
		.queryParam("page", "2")
		.when().get()
		.then()
		.statusCode(200)
		.contentType("application/json; charset=utf-8")
		.log().all();
	
			
	}

}
