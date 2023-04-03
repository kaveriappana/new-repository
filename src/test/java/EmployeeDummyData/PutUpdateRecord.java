package EmployeeDummyData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutUpdateRecord {
    @Test
    public void updateuser(){
        RestAssured.baseURI="https://dummy.restapiexample.com";
        RequestSpecification httprequest = RestAssured.given();

        httprequest.header("Content-Type","application/json");
        JSONObject json = new JSONObject();

        json.put("name","new");
        json.put("salary","423");
        json.put("age","23");

        httprequest.body(json.toJSONString());
        Response response = httprequest.request(Method.PUT,"/api/v1/update/21");

        int code = response.statusCode();
        System.out.println("Status code is "+code);

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);

        Assert.assertEquals(code,200);
        

        


    }
}
