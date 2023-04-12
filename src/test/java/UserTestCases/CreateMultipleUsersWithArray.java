package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class CreateMultipleUsersWithArray {
@Test(priority = 1)
    public void createusers() {
    Logger logger = Logger.getLogger("CreateMultipleUsersWithArray.class");
    PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
    Reporter.log("This is POST Request");
    Reporter.log("This request body contains id,username,lastname,email,password,phone,userstatus");

    String JsonData ="[\n" +
            "  {\n" +
            "    \"id\": 0,\n" +
            "    \"username\": \"abc\",\n" +
            "    \"firstName\": \"string\",\n" +
            "    \"lastName\": \"string\",\n" +
            "    \"email\": \"abc@gmail.com\",\n" +
            "    \"password\": \"abc\",\n" +
            "    \"phone\": \"123456789\",\n" +
            "    \"userStatus\": 0\n" +
            "  },\n" +
            "{\n" +
            "    \"id\": 0,\n" +
            "    \"username\": \"def\",\n" +
            "    \"firstName\": \"string\",\n" +
            "    \"lastName\": \"string\",\n" +
            "    \"email\": \"def@gmail.com\",\n" +
            "    \"password\": \"def\",\n" +
            "    \"phone\": \"123456789\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]";
    RestAssured.baseURI ="https://petstore.swagger.io";
    RequestSpecification httprequest = RestAssured.given();
    httprequest.basePath("/v2/user/createWithArray");
    Reporter.log("End point is /v2/user/createWithArray");
    httprequest.header("accept","application/json");
    Reporter.log("Header accept contains application/json");
    httprequest.header("Content-Type","application/json");
    Reporter.log("Header Content Type contains application/json");
    httprequest.body(JsonData);

    Response response = httprequest.post();

    String responsebody= response.getBody().asString();
    System.out.println("response body is "+responsebody);
    Reporter.log("Response body is "+responsebody);


    Assert.assertEquals(response.getStatusCode(),200);
    Reporter.log("status code is 200");
    System.out.println(response.getStatusCode());
    Reporter.log(String.valueOf(response.getStatusCode()));
    logger.info("Multiple users created");

}
}
