package org.testing.testSteps;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HTTPMethods {
	Properties pr;
	public HTTPMethods(Properties pr)
	{
	 this.pr=pr;	
	}
	public Response postrequest(String uriKey, String bodyData)
	{
		String uriValue = pr.getProperty(uriKey);
		Response res =given()
		.contentType(ContentType.JSON)
		.body(bodyData)
		.when()
		.post(uriValue);
		System.out.println("Status code is");
		System.out.println(res.statusCode());
		System.out.println(res.asString());
		return res;
	}
	
	public void updaterequest(String urikey, String idvalue, String bodydata)
	{
		String uri= pr.getProperty(urikey)+"/"+idvalue;
		Response res= given()
		.contentType(ContentType.JSON)
		.body(bodydata)
		.when()
		.put(uri);
		System.out.println("Status code is");
		System.out.println(res.statusCode());
		System.out.println(res.asString());
		
	}

	public void getAllRequest(String uriKey)
	{
		Response res =given()
		.contentType(ContentType.JSON)
		.when()
		.get(pr.getProperty(uriKey));
		System.out.println("Status code is");
		System.out.println(res.statusCode());
		System.out.println(res.asString());
	}
	
	public void getParticluarRecord(String uriKey, String idValue)
	{
		String uri= pr.getProperty(uriKey)+"/"+idValue;
		System.out.println("URI value "+ uri);
		Response res =
				given()
				.contentType(ContentType.JSON)
				.when()
				.get(uri);
		System.out.println("Status code is");
		System.out.println(res.statusCode());
		System.out.println(res.asString());
	}
	
	public void deleteRequest(String uriKey, String idValue)
	
	{
		String uri= pr.getProperty(uriKey)+"/"+idValue;
		System.out.println("URI value "+ uri);
		Response res =given()
		.contentType(ContentType.JSON)
		.when()
		.delete(uri);
		System.out.println("Status code is");
		System.out.println(res.statusCode());
		
	}
}
