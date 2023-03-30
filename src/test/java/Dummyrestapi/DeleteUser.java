package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUser {
    @Test
    public void deleteuser(){
        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.DELETE,"/api/users/2");

        String responsebody =  response.getBody().asString();
        System.out.println("response body is "+responsebody);

        Assert.assertEquals(response.getStatusCode(),204);
    }
}
