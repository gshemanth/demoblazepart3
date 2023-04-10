package com.testscripts.SampleApi;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req = RestAssured.given();
		Response res = req.get("/api/users/2");
		System.out.println(res.asPrettyString());
		System.out.println(res.statusCode());
		String status = JsonPath.from(res.asPrettyString()).get("email").toString();
	    Assert.assertTrue(res.equals("janet.weaver@reqres.in"));
		
		
		
		

	}

}
