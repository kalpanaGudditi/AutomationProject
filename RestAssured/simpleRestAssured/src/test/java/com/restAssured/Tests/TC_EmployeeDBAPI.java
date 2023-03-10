package com.restAssured.Tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class TC_EmployeeDBAPI {
@Test
public void test_getAllVideoGames() {
	given()
	
	.when()
	.get("https://dummy.restapiexample.com/api/v1/employees")
	.then()
	.statusCode(200)
	.log().all();
}
@Test
public void addNewEmployee() {
	HashMap data= new HashMap();
	data.put("name", "test");
	data.put("salary", "123");
	data.put("age", "23");
Response resp=
	given()
	.contentType("Application/Json")
	.body(data)
	.when()
	.post("https://dummy.restapiexample.com/api/v1/create")
	.then()
	.statusCode(200)
	.log().body()
	.extract().response();
String respo=resp.asString();
Assert.assertEquals(respo.contains("Successfully! Record has been fetched."), true);



}

	

@Test
public void  getSingleEmployee() {
	given()
	.when().get("https://dummy.restapiexample.com/api/v1/employee/1")
	.then()
	.log().all();

}
@Test
public void updateEmployee() {
	HashMap map=new HashMap();
	map.put("name", "kalpana");
	map.put("id", "24");
	given()
	.contentType("application/json")
.body(map)
.when()
.put("https://dummy.restapiexample.com/api/v1/update/21")
.then()
.statusCode(200)
.log().body()
.body("map.id",equalTo("24"))
.body("map.name", equalTo("kalpana"));
}

@Test
public void deleteEmployee() {
	Response res=given()
	.when()
	.delete("https://dummy.restapiexample.com/api/v1/delete/2")
	.then()
	.statusCode(200)
	.log().body()
	.extract().response();
	String response=res.asString();
	Assert.assertEquals(response.contains("message"),true);
	
}
}
