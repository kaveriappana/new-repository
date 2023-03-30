package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DelayedResponseOfUser {
    @Test
    public void delayedresponse(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET,"/api/users?delay=3");

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);

        Assert.assertTrue(responsebody.contains("\"total\":12"));
        Assert.assertTrue(responsebody.contains("\"per_page\":6"));

        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertEquals(response.getHeader("Server"),"cloudflare");


    }
}
