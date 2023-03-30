package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetListOfResource {
    @Test
    public void listofresouce(){
        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET,"/api/unknown");

        String header = response.getHeader("Content-Type");
        System.out.println("content type is "+header);
        Assert.assertEquals(header,"application/json; charset=utf-8");

        String body =response.getBody().asString();
        System.out.println("response body is "+body);


        JsonPath jsonpath = response.jsonPath();

        int page =  jsonpath.get("per_page");
        System.out.println("page value is "+page);
        Assert.assertEquals(page,6);

        String name = jsonpath.get("data[0].name");
        System.out.println("response body contains name is "+name);
        Assert.assertEquals(name,"cerulean");

       Assert.assertTrue(body.contains("\"name\":\"cerulean\""));


    }
}
