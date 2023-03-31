package EmployeeDummyData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEmploye {
    @Test
    public void createemployee(){
        RestAssured.baseURI="https://dummy.restapiexample.com";
        RequestSpecification httprequest =RestAssured.given();
        httprequest.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("name","test");
        json.put("salary","123");
        json.put("age","23");

        httprequest.body(json.toJSONString());
        Response response = httprequest.request(Method.POST,"/api/v1/create");

        String respbody =response.getBody().asString();
        System.out.println("response body "+respbody);

        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertTrue(respbody.contains("\"status\":\"success\""));




    }
}
