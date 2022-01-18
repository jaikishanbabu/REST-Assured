package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestClass {
	
	@Test
	public void test_1() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getHeader("cache-control"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	
	}

	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api/";
		given().
			get("users?page=2").
		then().
			statusCode(200).
		body("data[0].id", equalTo(7)).  //To use equalTo we need to import Matchers (Copy Matchers from REST Assured web "Document/Usage"
		log().all(); //To log the response 
				
	}
}
