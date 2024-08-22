package restassureddemoproject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SetupCheck {

	@Test
	public void SetUpCheck() {

		Response res = RestAssured.get("https://reqres.in/api/users/1");

		System.out.println(res.asString());
		System.out.println(res.statusCode());
		System.out.println(res.asPrettyString());

	}

}
