package restassureddemoproject;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AddPetXMLPayload {
	
	@Test
	public void payloadReqAddPet() {
		
		
		String xmlreqest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>doggie</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>2</id>\r\n"
				+ "			<name>doggie</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		RestAssured
		.given().baseUri("https://petstore.swagger.io")
		.basePath("v2/pet")
		.contentType(ContentType.XML)
		.body(xmlreqest)
		.when().post()
		.then()
		.statusCode(200)
		.body("name", Matchers.equalTo("doggie")).log().all();
		
	}
	@Test
	public void jsonPayloadAddPet() {
		
		
		
	}
	

}
