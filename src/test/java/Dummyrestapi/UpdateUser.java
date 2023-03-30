package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUser {
    @Test
    public void updateuser(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httprequest = RestAssured.given();
        JSONObject json = new JSONObject();
        json.put("name","morpheus");
        json.put("job","zion resident");

        httprequest.body(json.toJSONString());
        Response response = httprequest.request(Method.PUT,"/api/users/2");
        Assert.assertEquals(response.getStatusCode(),200);

        String responsebody =response.getBody().asString();
        System.out.println("Response body is "+responsebody);


    }
}
