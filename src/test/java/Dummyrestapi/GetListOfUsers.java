package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class GetListOfUsers {
    @Test
    public void getusers(){
        RestAssured.baseURI ="https://reqres.in/";
        RequestSpecification httprequest =RestAssured.given();
        Response response = httprequest.request(Method.GET,"/api/users?page=2");

        String body =response.getBody().asString();
        System.out.println("Response body is "+body);

        Assert.assertEquals(response.getStatusCode(),200);

        String header = response.getHeader("Content-Type");
        System.out.println("content type header is "+header);

        JsonPath jsonpath = response.jsonPath();

        System.out.println(Optional.ofNullable(jsonpath.get("total")));
        System.out.println(Optional.ofNullable(jsonpath.get("page")));


    }
}
