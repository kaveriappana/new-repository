package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class UpdateUser {
    @Test(priority = 5)
    public void updateuser(){
        Logger logger = Logger.getLogger(String.valueOf(CreateUser.class));
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");

        Reporter.log("This is a PUT request");
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

        Reporter.log("Request Endpoint is /v2/user/jack");
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("status code is 200");
        Reporter.log("Request body contains id,name,firstname,lastname,email,password,phone,userStatus");
        Reporter.log("Status code is 200");

        System.out.println(response.getTime());
        Reporter.log("Response time is :");
        Reporter.log(String.valueOf(response.getTime()));
        System.out.println( response.getBody().asString());
        Reporter.log("Response body is : ");
        Reporter.log( response.getBody().asString());

        Reporter.log("updated user");

    }
    @Test
    public void updatename(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Reporter.log("This is a PUT Request ");
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

        Reporter.log("End point is /v2/user/jack");
        Reporter.log("Request body contains id,username,firstname,lastname,email,password,phone,userstatus");

        request.body(json.toJSONString());
        Response response = request.request(Method.PUT,"/v2/user/jack");

        Assert.assertEquals(response.getStatusCode(),200);
        Reporter.log("Status code is 200");
        Reporter.log("User name updated");
    }
}
