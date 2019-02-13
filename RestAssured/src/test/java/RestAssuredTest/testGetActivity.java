package RestAssuredTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;

import apiActivities.getActivities;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import restApi.BaseClass;

public class testGetActivity extends BaseClass {
	BaseClass base;
	String BaseUrl;
	String BaseApi;
	getActivities Get;
	String Uri;

	@BeforeMethod
	public void Setup() {
		BaseUrl = prop.getProperty("url");
		BaseApi = prop.getProperty("apiActivities");
		Uri = BaseUrl + BaseApi;
	}

	@Test(priority = 1)
	public void getActvity() {
		System.out.println(" Running Test 1 ######\n");

		Get = new getActivities();
		Response response = Get.getRequest(Uri);

		// 1. Get Response Code
		int ResponseCode = response.getStatusCode();
		assertEquals(ResponseCode, 200);
		System.out.println(" Response code is " + ResponseCode);

		// 2. Get Response Body
		String ResponseBody = response.getBody().asString();
		System.out.println("Response Body :\n" + ResponseBody);

		// 3. Get Headers
		Headers Headers = response.getHeaders();
		System.out.println(Headers.toString());

		
	}

	@Test(priority = 2)
	public void getActivityviaio() {
		System.out.println(" Running Test 2 ######\n");
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = Uri;

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		
		io.restassured.response.Response response = httpRequest.request(Method.GET);

		// Now let us print the body of the message to see what response
		// we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		int respCode = response.getStatusCode();
		assertEquals(respCode, 200);
		System.out.println(" Response Code is =>>" + respCode);

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Fetch the Ids from the json repsonse
		System.out.println(" Id received is " + jsonPathEvaluator.get("ID"));
		
		String arr[] = responseBody.split("\\}"+","+"\\{");
		
		
		for(String s:arr) {
			String str = s.replace("\\["," ");
			System.out.println(str);
			
		}
		

	}

}
