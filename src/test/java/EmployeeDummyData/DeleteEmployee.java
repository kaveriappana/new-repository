package EmployeeDummyData;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteEmployee {
    @Test
    public void deleteemployee(){
        RestAssured.baseURI= "https://dummy.restapiexample.com";
        RequestSpecification httprequest =RestAssured.given();

        Response response = httprequest.request(Method.DELETE,"/api/v1/delete/2");

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertTrue(responsebody.contains("\"status\":\"success\""));
        Assert.assertTrue(responsebody.contains("\"message\":\"Successfully! Record has been deleted\""));


    }
}
