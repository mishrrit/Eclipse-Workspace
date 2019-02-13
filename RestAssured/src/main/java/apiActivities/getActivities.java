package apiActivities;

import java.util.HashMap;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import io.restassured.http.Method;

public class getActivities {

	public Response getRequest(String url) {

		System.out.println(" url received is " + url);
		RequestSpecification Reqspec = RestAssured.given();
		Reqspec.contentType(ContentType.JSON);
		Response resp = Reqspec.get(url);

		return resp;

	}

	public HashMap<String, String> Headers() {
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/json");
		header.put("Accept", "application/json");
		return header;

	}

	public Response getRequestIO(String url) {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = url;

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		return null;

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.

		

	}

}
