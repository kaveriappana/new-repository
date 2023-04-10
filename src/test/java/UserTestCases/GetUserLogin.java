package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class GetUserLogin {
    @Test(priority = 3)
    public  void loginuser(){
        Logger logger = Logger.getLogger(String.valueOf(CreateUser.class));
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");

        Reporter.log("This Request is GET:");
        Reporter.log("End Point is /v2/user/login?username=jack&password=jack");
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.GET,"/v2/user/login?username=jack&password=jack");

        int statuscode =response.getStatusCode();
        System.out.println("Status code is "+statuscode);
        Assert.assertEquals(statuscode,200);
        Reporter.log("Status code is 200");

        String type = response.jsonPath().get("type");
        System.out.println("type is "+type);
        Assert.assertEquals("unknown",type);
        Reporter.log("Response body contains type is UnKnown");

        String statusline=response.getStatusLine();
        System.out.println("Status line "+statusline);
        Reporter.log("Status line contains "+statusline);

        Reporter.log("Response time is ");
        Reporter.log(String.valueOf(response.getTime()));

        String content =response.getHeader("Content-Type");
        System.out.println("content type is " +content);
        Assert.assertEquals(content,"application/json");
        Reporter.log("Header contains content-type is "+content);

        logger.info("user login");
        Reporter.log("user login done");


    }
}
