package test;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



public class GetAndPostExamples {
	
	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api/";
		
		given().
			get("users?page=2").
		then().
			statusCode(200).
		body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Byron"));
	}
	
	@Test
	public void testPost() {
	
		baseURI = "https://reqres.in/api/";
				
		JSONObject request = new JSONObject();
		request.put("name", "Jai");
		request.put("Job", "QA");
		System.out.println(request.toJSONString());

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON). //Explicitly mentioning the content which I am sending is of type JSON
		accept(ContentType.JSON).		// Content I'll accept should also be of type JSON
		body(request.toJSONString()).
			when().
		post("users").
			then().
		statusCode(201).
			log().all();
	}
}
