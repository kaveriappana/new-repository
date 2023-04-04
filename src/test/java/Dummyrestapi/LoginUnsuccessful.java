package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUnsuccessful {
    @Test
    public void unsuccessfullogin(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httprequest = RestAssured.given();
        httprequest.header("Content-Type","application/json; charset=utf-8");
        JSONObject json = new JSONObject();
        json.put("email","peter@klaven");

        httprequest.body(json.toJSONString());

        Response response = httprequest.request(Method.POST,"/api/login");

        String responsebody = response.getBody().asString();
        System.out.println("response body is "+responsebody);

        String expectedresponsebody ="{\"error\":\"Missing password\"}";
        Assert.assertTrue(responsebody.contains(expectedresponsebody));

        Assert.assertEquals(response.getStatusCode(),400);
        System.out.println(response.getStatusLine());
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 400 Bad Request");

    }
}
