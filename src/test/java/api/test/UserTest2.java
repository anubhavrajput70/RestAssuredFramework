package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.UserPojo;
import io.restassured.response.Response;

//this test is with properties file
public class UserTest2 {

	Faker faker;
	UserPojo userPayload;

	public Logger logger;

	// for creating userdata
	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new UserPojo();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		// log
		logger = LogManager.getLogger(this.getClass());

	}

	@Test(priority = 1)
	public void testPostUser() {
		logger.info("*******************Creting user************************");

		Response response = UserEndpoints2.createUser(userPayload);

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*******************user Created************************");
	}

	@Test(priority = 2)
	public void testGetUser() {
		logger.info("*******************Reading user info************************");
		Response response = UserEndpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*******************user info displayed************************");
	}

	@Test(priority = 3)
	public void testUpdateByName() {
		logger.info("*******************updating user info************************");
		// update data using payload
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndpoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);

		// checking data after udpate
		Response responseAfterUpdate = UserEndpoints2.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		logger.info("*******************user updated************************");

	}

	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("*******************deleting user************************");
		Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*******************user deleted************************");
	}
}
