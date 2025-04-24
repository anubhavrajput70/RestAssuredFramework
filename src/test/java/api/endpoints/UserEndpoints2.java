package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//this test is with properties file 
//created to perform create, read, update, delete request to the user API with properties file
public class UserEndpoints2 {
	
	//method created for getting the urls from the properties file
	public static ResourceBundle getURL()
	{
		//this getBundle() method by default looks for the properties file in the rosources folder
		//this will load the properties file
		//routes is the name of the properties file
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(UserPojo payload)
	{
		String url =getURL().getString("post_url");
		Response response =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(url);

		return response;
	}
	
	public static Response readUser(String username)
	{
		String url =getURL().getString("get_url");
		Response response =given()
			.pathParam("username", username)
		
		.when()
			.get(url);
	
		return response;
	}
	
	public static Response updateUser(String username, UserPojo payload)
	{
		String url =getURL().getString("put_url");
		Response response =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		
		.when()
			.put(url);
	
		return response;
	}
	
	public static Response deleteUser(String username)
	{
		String url =getURL().getString("delete_url");
		Response response =given()
			.pathParam("username", username)
		
		.when()
			.delete(url);
	
		return response;
	}
	
}
