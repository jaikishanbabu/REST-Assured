package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class XMLSchemaValidation {
	
	@Test
	public void schemaValidation() throws IOException {
		 
baseURI ="http://www.dneonline.com";
		
		
		File file = new File("./SoapRequests/Add.xml");
		
		if(file.exists())
			System.out.println("  >>  File Exists");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(requestBody).
		when()
			.post("/calculator.asmx?op=Add\"")
		.then()
			.statusCode(200).log().all()
		.and()
			.body("//*:AddResult.text()", equalTo("7"))
		.and()
			.body(matchesXsdInClasspath("calculator.xsd"));
	}

}
