package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalAPI {
	
	//@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		
		given().
			get("/users").
		then().statusCode(200).log().all();
	}
	
	//@Test
	public void post() {
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Jai");
		request.put("secondName", "Kishan");
		request.put("subjectID", 2);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then().
			statusCode(201).log().all();
	}
	
	//@Test
	public void put() {
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "MS");
		request.put("secondName", "Dhoni");
		request.put("subjectID", 2);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/1")
		.then().
			statusCode(200).log().all();
	}
	
	//@Test
	public void patch() {
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Mahendra Singh");
		
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/1")
		.then().
			statusCode(200).log().all();
	}
	
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000";
		
		when().delete("/users/3").then().statusCode(200).log().all();
	}
}
