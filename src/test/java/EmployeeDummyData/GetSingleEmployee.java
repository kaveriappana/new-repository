package EmployeeDummyData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleEmployee {
    @Test
    public void getsingleemployee(){
        RestAssured.baseURI="https://dummy.restapiexample.com/";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET,"api/v1/employee/1");

        String body = response.getBody().asString();
        System.out.println("Response body is "+body);

        Assert.assertTrue(body.contains("\"status\":\"success\""));
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(body.contains("\"employee_name\":\"Tiger Nixon\""));


    }
}
