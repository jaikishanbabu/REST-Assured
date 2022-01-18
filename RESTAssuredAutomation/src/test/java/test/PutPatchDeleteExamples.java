package test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples {
	
	@Test
	public void testPut() {
		
		baseURI = "https://reqres.in" ;
		
		JSONObject request = new JSONObject();
		request.put("name", "Jai");
		request.put("Job", "QA");
		
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testPatch() {
		
		baseURI = "https://reqres.in" ;
		
		JSONObject request = new JSONObject();
		request.put("name", "Jai");
		request.put("Job", "QA");
		
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in" ;
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
		log().all();
		
		
		
	}

}
