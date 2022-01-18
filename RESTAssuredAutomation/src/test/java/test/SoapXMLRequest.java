package test;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;


public class SoapXMLRequest {
	
	
	@Test
	public void validSoapXML() throws IOException {
		
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
			.body("//*:AddResult.text()", equalTo("7"));
		
		
		
	}
	
	

}
