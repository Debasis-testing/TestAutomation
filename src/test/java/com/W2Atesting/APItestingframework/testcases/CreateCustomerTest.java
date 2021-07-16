package com.W2Atesting.APItestingframework.testcases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.W2Atesting.APItestingframework.SetUp.BaseTest;
import com.ctc.wstx.util.DataUtil;
import com.w2a.APITestingFramework.utilities.DataUtilitiesForProject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {

	
	@Test(dataProviderClass=DataUtilitiesForProject.class,dataProvider="getData")
	public void validateCreateCustomerApiWithValidSecretkey(String email,String description,String address) {
	
	    Response response=	given().auth().basic(config.getProperty("validSecretkey"), "")
		.formParam("email", email)
		.formParam("description", description).formParam("name", address).post(config.getProperty("customerAPIEndpoint"));
	    response.prettyPrint();
	   System.out.println( response.statusCode());
	   Assert.assertEquals(response.statusCode(), 200);
		
}
	@Test(dataProviderClass=DataUtilitiesForProject.class,dataProvider="getData")
	public void validateCreateCustomerApiWithInValidSecretkey(String email,String description,String address) {
			
	Response response=	given().auth().basic(config.getProperty("validSecretkey"), "")
		.formParam("email", email)
		.formParam("description", description).formParam("name", address).post(config.getProperty("customerAPIEndpoint"));
	 response.prettyPrint();
	 System.out.println( response.statusCode());
	 Assert.assertEquals(response.statusCode(), 200);
}
	
	}