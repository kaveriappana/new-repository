package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRegisterUser {
    @Test
    public void registerlogin(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httprequest = RestAssured.given();
        httprequest.header("Content-Type","application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("email","eve.holt@reqres.in");
        json.put("password","pistol");

        httprequest.body(json.toJSONString());

        Response response = httprequest.request(Method.POST,"/api/register");

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);

        String expectedbody = "{\"id\":4,\"token\":\"QpwL5tke4Pnpja7X4\"}";
        Assert.assertTrue(responsebody.contentEquals(expectedbody));

        Assert.assertTrue(responsebody.contains("\"id\":4"));


    }
}
