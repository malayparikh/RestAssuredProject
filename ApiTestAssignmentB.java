package restassureddemoproject;

import java.lang.reflect.Method;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiTestAssignmentB {
	
	
	ExtentReports extent;
	ExtentTest test;
	String baseURI="https://api.restful-api.dev/objects";
	
	@BeforeClass
	public void setupExtent() {
		
		
		// Initialize ExtentReport once before all test methods
		ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		RestAssured.baseURI=baseURI;

	}
	
	@BeforeMethod
	public void startTest(Method method) {
		
		test = extent.createTest(method.getName());
	}
	@AfterMethod
	public void logTestResult(ITestResult result) {;
		
		
		if(result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable()); // Log the error in the report
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test Passed");
					
		}else if (result.getStatus() == ITestResult.SKIP) {
			
			test.skip("Test Skipped: " + result.getThrowable());
		}
		
		extent.flush();
	}
	
	@AfterClass
	public void teardownExten() {
		
		if(extent != null) {
			extent.flush();
		}
	}
	
	@Test
	public void verifyStatusCode() {
		
		test.info("Starting test case to verify the status code");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"Apple MacBook Pro 16\",\r\n"
						+ "    \"data\": {\r\n"
						+ "        \"year\": 2019,\r\n"
						+ "        \"price\": 1849.99,\r\n"
						+ "        \"CPU model\": \"Intel Core i9\",\r\n"
						+ "        \"Hard disk size\": \"1 TB\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.post()
				.then()
				.extract().response();
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		test.pass("Verified status code is 201");
	//	test.fail("Please check once again!");
		
		
	}
	@Test
	public void verifyContentType() {
		
test.info("Starting test case to verify Content Type");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"Apple MacBook Pro 16\",\r\n"
						+ "    \"data\": {\r\n"
						+ "        \"year\": 2019,\r\n"
						+ "        \"price\": 1849.99,\r\n"
						+ "        \"CPU model\": \"Intel Core i9\",\r\n"
						+ "        \"Hard disk size\": \"1 TB\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when()
				.post()
				.then()
				.extract().response();
		
		String contentType=response.getHeader("Content-Type");
		Assert.assertEquals(contentType, "application/json123");
		test.pass("Verified Content Type is application/json");
		
		
		
	}
	
	
	
	
	

}
