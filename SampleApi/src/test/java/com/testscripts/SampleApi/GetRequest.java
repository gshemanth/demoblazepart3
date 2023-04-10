package com.testscripts.SampleApi;



import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	public static void main(String[] args){
		RestAssured.baseURI="https://simple-books-api.glitch.me";
		RequestSpecification req = RestAssured.given();
		Response res = req.get("/status");
		System.out.println(res.asPrettyString());
		System.out.println("status code==>"+res.statusCode());
		//System.out.println(res.asPrettyString());
		Assert.assertTrue(res.statusCode()==200);
		String status= JsonPath.from(res.asPrettyString()).get("status").toString();
		Assert.assertTrue(status.equals("OK"));
		
		
		
		
	}

}
