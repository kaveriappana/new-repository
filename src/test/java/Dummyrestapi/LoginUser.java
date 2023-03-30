package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUser {
    @Test
    public void loginuser(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httprequest = RestAssured.given();
        httprequest.header("Content-Type","application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("email","eve.holt@reqres.in");
        json.put("password","cityslicka");

        httprequest.body(json.toJSONString());

        Response response = httprequest.request(Method.POST,"/api/login");

        String responsebody =response.getBody().asString();
        System.out.println("Response body is "+responsebody);

        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertTrue(responsebody.contains("\"token\":\"QpwL5tke4Pnpja7X4\""));




    }
}
