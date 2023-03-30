package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class GetSingleUser {
    @Test
    public void getsingleuser(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httprequest =RestAssured.given();
        Response response = httprequest.request(Method.GET,"/api/users/2");

        String responsebody = response.getBody().asString();
        System.out.println("response body is "+responsebody);

        Assert.assertEquals(response.getStatusCode(),200);

        String contenttype = response.contentType();
        System.out.println("response body contains header is "+contenttype);
        Assert.assertEquals(contenttype,"application/json; charset=utf-8");

        String server =response.header("Server");
        System.out.println("server is "+server);
        Assert.assertEquals(server,"cloudflare");
    }
    @Test
    public void getsingleusernotfound(){
        RestAssured.baseURI="https://reqres.in";
        RequestSpecification httprequest =RestAssured.given();
        Response response = httprequest.request(Method.GET,"/api/users/23");

        String responsebody = response.getBody().asString();
        System.out.println("response body is "+responsebody);

        Assert.assertEquals(response.getStatusCode(),404);

        String contenttype = response.contentType();
        System.out.println("response body contains header is "+contenttype);
        Assert.assertEquals(contenttype,"application/json; charset=utf-8");

        String expectedResponse = "{}";
        Assert.assertTrue(responsebody.contentEquals(expectedResponse));



    }
}
