package api.endpoints;

//this class will only contains urls

/*
 * Swagger URI: https://petstore.swagger.io/
 * 
 * base URL : petstore.swagger.io/v2 
 * create user (Post) : petstore.swagger.io/v2/user
 * Get user (Get) : petstore.swagger.io/v2/user/{username}
 * Update user (Put) : petstore.swagger.io/v2/user/{username}
 * Delete user (Delete) : petstore.swagger.io/v2/user/{username}
 * */
public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	
	

}
