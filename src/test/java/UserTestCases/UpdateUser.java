package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateUser {
    @Test(priority = 5)
    public void updateuser(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("id","0");
        json.put("username","jack");
        json.put( "firstName","new");
        json.put("lastName","update");
        json.put("email","jack@gmail");
        json.put("password","jack");
        json.put("phone","123456789");
        json.put("userStatus","0");

        request.body(json.toJSONString());
        Response response = request.request(Method.PUT,"/v2/user/jack");

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println(response.getTime());
        System.out.println( response.getBody().asString());

    }
    @Test
    public void updatename(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("id","0");
        json.put("username","jacknew");
        json.put( "firstName","new");
        json.put("lastName","update");
        json.put("email","jack@gmail");
        json.put("password","jack");
        json.put("phone","123456789");
        json.put("userStatus","0");

        request.body(json.toJSONString());
        Response response = request.request(Method.PUT,"/v2/user/jack");

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
