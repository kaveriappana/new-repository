package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class CreateUser {
    @Test(priority = 2)
    public void createuser(){
        Logger logger = Logger.getLogger("CreateUser.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredTestingProject\\src\\main\\resources\\log4j.properties");

        Reporter.log("This is Post request");
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("id","0");
        json.put("username","jack");
        json.put( "firstName","jo");
        json.put("lastName","lee");
        json.put("email","jack@gmail.com");
        json.put("password","jack");
        json.put("phone","78987869");
        json.put("userStatus","0");

        request.body(json.toJSONString());
        Response response =request.post("https://petstore.swagger.io/v2/user");

        Reporter.log("Request body contains id,name,firstname,lastname,email,password,phone,userStatus");
        int code = response.getStatusCode();
        System.out.println("status code :"+code);
        logger.info("status code is 200");
        Reporter.log("Status code is 200");

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);
        Assert.assertTrue(responsebody!=null);

        System.out.println(response.getTime());
        Reporter.log("Response time is ");
        Reporter.log(String.valueOf(response.getTime()));
        System.out.println(response.getStatusLine());
        Reporter.log("Response Status Line is ");
        Reporter.log(response.getStatusLine());

        JsonPath jsonpath = response.jsonPath();
        System.out.println((String) jsonpath.get("type"));
        Assert.assertEquals(jsonpath.get("type"),"unknown");
        System.out.println((String) jsonpath.get("message"));

        Reporter.log("Response body is ");
        Reporter.log(responsebody.toString());
        Reporter.log("User created successfully");

    }
}
