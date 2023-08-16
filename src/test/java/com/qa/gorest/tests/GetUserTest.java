package com.qa.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpStatus;

import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {
	
	@BeforeMethod
	public void getUserSetup() {
		restClient = new RestClient(prop, baseURI);
		
	}
	
	//RestClient restClient;
	// code smell: sonarQube
	@Test()
	public void getAllUsersTest() {
	//	restClient = new RestClient();
		restClient.get(GOREST_ENDPOINT, true,true)
					.then().log().all()
						.assertThat().statusCode(APIHttpStatus.OK_200.getCode());
						
	}
	
	
	@Test(enabled=true)
	public void getUserTest() {
//	restClient = new RestClient(prop, baseURI);
		restClient.get(GOREST_ENDPOINT +"/"+4464653, true, true)
					.then().log().all()
						.assertThat().statusCode(APIHttpStatus.OK_200.getCode())
							.and().body("id", equalTo(4316178));
						
	}
		
	@Test()
	public void getUserWithQueryParamsTest() {
	restClient = new RestClient(prop, baseURI);
	restClient = new RestClient(prop, baseURI);
		Map<String,String> queryParams = new HashMap<String,String>();
		queryParams.put("name", "naveen");
		queryParams.put("status", "active");

		restClient.get(GOREST_ENDPOINT, queryParams, true, true)
					.then().log().all()
						.assertThat().statusCode(APIHttpStatus.OK_200.getCode());
							
					

}
	
	
	
}
