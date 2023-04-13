package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static io.restassured.RestAssured.baseURI;

public class LoginUser {
    @Test
    public void createuser(){
        Logger logger = Logger.getLogger("LoginUser.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        baseURI="https://petstore.swagger.io";
        Reporter.log("This is Post request");
        RequestSpecification httprequest = RestAssured.given();
        JSONObject json = new JSONObject();
        json.put("id","0");
        json.put("username","phani");
        json.put( "firstName","veera");
        json.put("lastName","venkata");
        json.put("email","perumalla@gmail.com");
        json.put("password","kaveri");
        json.put("phone","78987869");
        json.put("userStatus","0");

        Response response =httprequest.when().
                header("accept","application/json").
                header("Content-Type","application/json").
                body(json.toJSONString()).post(baseURI+"/v2/user");
        String responsebody = response.getBody().asString();
        System.out.println("response body is :"+responsebody);
        Reporter.log("End point is /v2/user");
        Reporter.log("Response body is : "+responsebody);
        Reporter.log("Status code is 200");
        Reporter.log("User created successfully");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(responsebody.contains("\"code\":200"));
        Assert.assertTrue(responsebody.contains("\"type\":\"unknown\""));
    }
    @Test
    public void loginuser(){
        Logger logger = Logger.getLogger("LoginUser.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        baseURI="https://petstore.swagger.io";
        Reporter.log("This request is Get request");
        Reporter.log("End point is : /v2/user/login");
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.when().
                header("accept","application/json").
                queryParams("username","phani").
                queryParams("password ","kaveri").get(baseURI +"/v2/user/login");

        String responsebody = response.getBody().asString();
        System.out.println("response body is : "+responsebody);
        Reporter.log("Response body is : "+responsebody);
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");
        Assert.assertTrue(responsebody.contains("\"type\":\"unknown\""));
        Assert.assertTrue(responsebody.contains("\"code\":200"));
        Reporter.log("user login successfull");
        logger.info("user login successfull");
    }
    @Test
    public void delete(){
        Logger logger = Logger.getLogger("LoginUser.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        baseURI="https://petstore.swagger.io";
        Reporter.log("This is delete request");
        Reporter.log("End point is : /v2/user/phani");
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.when().
                header("accept","application/json").
                delete(baseURI+"/v2/user/phani");
        String responsebody = response.getBody().asString();
        System.out.println("Response body is : "+responsebody);
        Reporter.log("Response body is : "+responsebody);
        Assert.assertEquals(response.getStatusCode(),200);
        Reporter.log("user deleted successfully");
    }
    @Test
    public void userbyname(){
        Logger logger = Logger.getLogger("LoginUser.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        baseURI="https://petstore.swagger.io";
        Reporter.log("This is get request");
        Reporter.log("End point is : /v2/user/phani");
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.when().
                header("accept","application/json").
                get(baseURI+"/v2/user/phani");
        String responsebody = response.getBody().asString();
        System.out.println("Response body is :"+responsebody);
        Reporter.log("Response body is : "+responsebody);
        Reporter.log("Get user by name");
    }
    @Test
    public void updateuser(){
        Logger logger = Logger.getLogger("LoginUser.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        baseURI="https://petstore.swagger.io";
        Reporter.log("This Request is Update request");
        Reporter.log("End point is : /v2/user/phani");
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.when().
                header("accept","application/json").
                header("Content-Type","application/json").
                body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"phani\",\n" +
                        "  \"firstName\": \"veera\",\n" +
                        "  \"lastName\": \"perumalla\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"kaveri\",\n" +
                        "  \"phone\": \"9959021532\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}").
                put(baseURI+"/v2/user/phani");
        String responsebody = response.getBody().asString();
        System.out.println("Response body is :"+responsebody);
        Reporter.log("Response body is : "+responsebody);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        Reporter.log("Status code is 200");
        Assert.assertTrue(responsebody.contains("\"code\":200"));
        Assert.assertTrue(responsebody.contains("\"type\":\"unknown\""));
        Reporter.log("User Updated Successfully");
    }
}
