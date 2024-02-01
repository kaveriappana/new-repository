package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDummyuser {
    @Test
    public void createemployee(){
        RestAssured.baseURI="https://www.dummy.restapiexample.com";
        RequestSpecification httprequest = RestAssured.given();

        httprequest.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("name","test");
        json.put("salary","123");
        json.put("age","23");

        httprequest.body(json.toJSONString());
        Response response = httprequest.request(Method.POST,"/api/v1/create");
        System.out.println(response.getStatusCode());

        String body = response.getBody().asString();
        System.out.println("response body is "+body);

        Assert.assertTrue(body.contains("\"status\":\"success\""));
        Assert.assertTrue(body.contains("\"message\":\"Successfully! Record has been added.\""));




    }
}
