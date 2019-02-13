package apiActivities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class postActivities {

	
	public Response postActivities (String url,String JsonBody) {
		System.out.println(" url received is " + url);
		RequestSpecification Reqspec = RestAssured.given().body(JsonBody);
		Reqspec.contentType(ContentType.JSON);
		Reqspec.accept(ContentType.JSON);
		Response resp = Reqspec.post(url);
		return resp;
		
	}
}
