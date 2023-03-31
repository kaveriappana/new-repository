package EmployeeDummyData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllEmployes {
    @Test
    public void getallemployess(){
        RestAssured.baseURI="https://dummy.restapiexample.com";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET,"/api/v1/employees");

        String header=response.getHeader("Content-Type");
        System.out.println("header is "+header);

        Assert.assertEquals(response.getStatusCode(),200);
        String body = response.getBody().asString();
        System.out.println("response body is "+body);

        Assert.assertTrue(body.contains("\"status\":\"success\""));

    }
}
