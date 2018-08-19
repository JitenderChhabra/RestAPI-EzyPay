package com.ezypay.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ezypay.common.Common;
import com.ezypay.common.FileUtils;
import com.ezypay.common.PropertyConstants;
import com.ezypay.utills.EndPointURL;
import com.ezypay.utills.URL;
import com.ezypay.webservices.methods.Webservices;
import com.jayway.restassured.response.Response;

public class LoginScenarios {
	Response response;

	@BeforeClass
	public void setUp() {
	}

	@Test
	public void LoginWithValidCredentials() throws Exception {

		String body = FileUtils.readFile("serviceLogin.JSON");

		body = body.replaceAll(Common.getResponsePath("username", body)
				.toString(), PropertyConstants.APPSETTINGS_VALID_USERNAME);

		body = body.replaceAll(Common.getResponsePath("password", body)
				.toString(), PropertyConstants.APPSETTINGS_VALID_PASSWORD);

		String url = URL.fixURL + EndPointURL.LOGIN.getResourcePath();

		response = Webservices.Post(url, body);

		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());

		String actualUserName = response.body().path("username");
		String expectedUserName = "test-user";

		String actualPassword = response.body().path("password");
		String expectedPassword = "abc123";

		assertEquals(response.getStatusCode(), 200);
		assertEquals(actualUserName, expectedUserName, "Expected was : "
				+ expectedUserName + "However received : " + actualUserName);
		assertEquals(actualPassword, expectedPassword, "Expected was :"
				+ expectedPassword + "However received : " + actualPassword);
	}

	
	@Test
	public void InValidUserName() throws Exception {
		String body = FileUtils.readFile("serviceLogin.JSON");

		body = body.replaceAll(Common.getResponsePath("username", body)
				.toString(), PropertyConstants.APPSETTINGS_INVALID_USERNAME);

		body = body.replaceAll(Common.getResponsePath("password", body)
				.toString(), PropertyConstants.APPSETTINGS_VALID_PASSWORD);

		String url = URL.fixURL + EndPointURL.LOGIN.getResourcePath();

		response = Webservices.Post(url, body);

		String actualCode = response.body().path("Code");
		String expectedCode = "UnauthorizedError";

		String actualMessage = response.body().path("Message");
		String expectedMessage = "UnauthorizedError: invalid username or password";

		assertEquals(response.getStatusCode(), 401);
		assertEquals(actualCode, expectedCode, "Expected was :" + expectedCode
				+ "However received : " + actualCode);
		assertEquals(actualMessage, expectedMessage, "Expected was : "
				+ expectedMessage + "However received : " + actualMessage);
	}
	
	
	@Test
	public void InValidPassword() throws Exception {
		String body = FileUtils.readFile("serviceLogin.JSON");

		body = body.replaceAll(Common.getResponsePath("username", body)
				.toString(), PropertyConstants.APPSETTINGS_VALID_USERNAME);

		body = body.replaceAll(Common.getResponsePath("password", body)
				.toString(), PropertyConstants.APPSETTINGS_INVALID_PASSWORD);

		String url = URL.fixURL + EndPointURL.LOGIN.getResourcePath();

		response = Webservices.Post(url, body);

		String actualCode = response.body().path("Code");
		String expectedCode = "UnauthorizedError";

		String actualMessage = response.body().path("Message");
		String expectedMessage = "UnauthorizedError: invalid username or password";

		assertEquals(response.getStatusCode(), 401);
		assertEquals(actualCode, expectedCode, "Expected was :" + expectedCode
				+ "However received : " + actualCode);
		assertEquals(actualMessage, expectedMessage, "Expected was : "
				+ expectedMessage + "However received : " + actualMessage);
	}
	
	
	@Test
	public void SpecialCharacterInUserName() throws Exception {
		String body = FileUtils.readFile("serviceLogin.JSON");

		body = body.replaceAll(Common.getResponsePath("username", body)
				.toString(), PropertyConstants.APPSETTINGS_SPECIAL_CHARACTER_USERNAME);

		body = body.replaceAll(Common.getResponsePath("password", body)
				.toString(), PropertyConstants.APPSETTINGS_VALID_PASSWORD);

		String url = URL.fixURL + EndPointURL.LOGIN.getResourcePath();

		response = Webservices.Post(url, body);

		String actualCode = response.body().path("Code");
		String expectedCode = "UnauthorizedError";

		String actualMessage = response.body().path("Message");
		String expectedMessage = "UnauthorizedError: invalid username or password";

		assertEquals(response.getStatusCode(), 401);
		assertEquals(actualCode, expectedCode, "Expected was :" + expectedCode
				+ "However received : " + actualCode);
		assertEquals(actualMessage, expectedMessage, "Expected was : "
				+ expectedMessage + "However received : " + actualMessage);
	}
	
	
	@Test
	public void SpecialCharacterInPassword() throws Exception {
		String body = FileUtils.readFile("serviceLogin.JSON");

		body = body.replaceAll(Common.getResponsePath("username", body)
				.toString(), PropertyConstants.APPSETTINGS_VALID_USERNAME);

		body = body.replaceAll(Common.getResponsePath("password", body)
				.toString(), PropertyConstants.APPSETTINGS_SPECIAL_CHARACTER_PASSWORD);

		String url = URL.fixURL + EndPointURL.LOGIN.getResourcePath();

		response = Webservices.Post(url, body);

		String actualCode = response.body().path("Code");
		String expectedCode = "UnauthorizedError";

		String actualMessage = response.body().path("Message");
		String expectedMessage = "UnauthorizedError: invalid username or password";

		assertEquals(response.getStatusCode(), 401);
		assertEquals(actualCode, expectedCode, "Expected was :" + expectedCode
				+ "However received : " + actualCode);
		assertEquals(actualMessage, expectedMessage, "Expected was : "
				+ expectedMessage + "However received : " + actualMessage);
	}
	
	
	@Test
	public void SpecialCharacterInUserCredentials() throws Exception {
		String body = FileUtils.readFile("serviceLogin.JSON");

		body = body.replaceAll(Common.getResponsePath("username", body)
				.toString(), PropertyConstants.APPSETTINGS_SPECIAL_CHARACTER_USERNAME);

		body = body.replaceAll(Common.getResponsePath("password", body)
				.toString(), PropertyConstants.APPSETTINGS_SPECIAL_CHARACTER_PASSWORD);

		System.out.println("Print Body  : " + body);
		
		String url = URL.fixURL + EndPointURL.LOGIN.getResourcePath();
		System.out.println("URL is   :" + url);
		response = Webservices.Post(url, body);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());

		String actualCode = response.body().path("Code");
		String expectedCode = "UnauthorizedError";

		String actualMessage = response.body().path("Message");
		String expectedMessage = "UnauthorizedError: invalid username or password";

		assertEquals(response.getStatusCode(), 401);
		assertEquals(actualCode, expectedCode, "Expected was :" + expectedCode
				+ "However received : " + actualCode);
		assertEquals(actualMessage, expectedMessage, "Expected was : "
				+ expectedMessage + "However received : " + actualMessage);
	}	
	
	
	@Test
	public void LongUserName() throws Exception {
		String body = FileUtils.readFile("serviceLogin.JSON");

		body = body.replaceAll(Common.getResponsePath("username", body)
				.toString(), PropertyConstants.APPSETTINGS_LONG_USERNAME);

		body = body.replaceAll(Common.getResponsePath("password", body)
				.toString(), PropertyConstants.APPSETTINGS_VALID_PASSWORD);

		String url = URL.fixURL + EndPointURL.LOGIN.getResourcePath();

		response = Webservices.Post(url, body);

		String actualCode = response.body().path("Code");
		String expectedCode = "UnauthorizedError";

		String actualMessage = response.body().path("Message");
		String expectedMessage = "UnauthorizedError: invalid username or password";

		assertEquals(response.getStatusCode(), 401);
		assertEquals(actualCode, expectedCode, "Expected was :" + expectedCode
				+ "However received : " + actualCode);
		assertEquals(actualMessage, expectedMessage, "Expected was : "
				+ expectedMessage + "However received : " + actualMessage);
	}
	
	
	@Test
	public void LongPassword() throws Exception {
		String body = FileUtils.readFile("serviceLogin.JSON");

		body = body.replaceAll(Common.getResponsePath("username", body)
				.toString(), PropertyConstants.APPSETTINGS_VALID_USERNAME);

		body = body.replaceAll(Common.getResponsePath("password", body)
				.toString(), PropertyConstants.APPSETTINGS_LONG_PASSWORD);
		
		String url = URL.fixURL + EndPointURL.LOGIN.getResourcePath();

		response = Webservices.Post(url, body);

		String actualCode = response.body().path("Code");
		String expectedCode = "UnauthorizedError";

		String actualMessage = response.body().path("Message");
		String expectedMessage = "UnauthorizedError: invalid username or password";

		assertEquals(response.getStatusCode(), 401);
		assertEquals(actualCode, expectedCode, "Expected was :" + expectedCode
				+ "However received : " + actualCode);
		assertEquals(actualMessage, expectedMessage, "Expected was : "
				+ expectedMessage + "However received : " + actualMessage);
	}
	
}
