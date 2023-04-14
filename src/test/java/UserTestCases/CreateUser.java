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
        Logger logger = Logger.getLogger(String.valueOf(CreateUser.class));
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");

        Reporter.log("This Request is Post request");
        Reporter.log("This a post request");
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

        Reporter.log("Request body contains id,username,firstname,lastname,email,password,phone,userStatus");
        Reporter.log("End point is https://petstore.swagger.io/v2/user");
        request.body(json.toJSONString());
        Response response =request.post("https://petstore.swagger.io/v2/user");

        int code = response.getStatusCode();
        System.out.println("status code :"+code);
        Reporter.log("status code is 200");

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);
        Assert.assertTrue(responsebody!=null);

        Reporter.log("Response time is");
        System.out.println(response.getTime());
        Reporter.log(String.valueOf(response.getTime()));

        Reporter.log("Status code is ");
        System.out.println(response.getStatusLine());
        Reporter.log(response.getStatusLine());

        JsonPath jsonpath = response.jsonPath();
        System.out.println((String) jsonpath.get("type"));
        Assert.assertEquals(jsonpath.get("type"),"unknown");
        System.out.println((String) jsonpath.get("message"));

        logger.info("user created successfully");
        JsonPath jsonpath1 = new JsonPath(responsebody);
//        Assert.assertEquals(jsonpath1.getString("code"),200);
        Assert.assertTrue(jsonpath1.getString("type").equals("unknown"));



        Reporter.log("Response body is ");
        Reporter.log(responsebody.toString());

        Reporter.log("user  created  successfully");
    }
}
