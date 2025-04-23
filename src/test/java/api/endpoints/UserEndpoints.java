package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//created to perform create, read, update, delete request to the user API
public class UserEndpoints {
	
	public static Response createUser(UserPojo payload)
	{
		Response response =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.post_url);

		return response;
	}
	
	public static Response readUser(String username)
	{
		Response response =given()
			.pathParam("username", username)
		
		.when()
			.get(Routes.get_url);
	
		return response;
	}
	
	public static Response updateUser(String username, UserPojo payload)
	{
		Response response =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		
		.when()
			.put(Routes.put_url);
	
		return response;
	}
	
	public static Response deleteUser(String username)
	{
		Response response =given()
			.pathParam("username", username)
		
		.when()
			.delete(Routes.delete_url);
	
		return response;
	}
	
}
