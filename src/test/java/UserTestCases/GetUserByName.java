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

public class GetUserByName {
    @Test(priority = 4)
    public void getuser(){
        Logger logger = Logger.getLogger(String.valueOf(CreateUser.class));
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");

        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/user/jack");

        String header = response.header("Content-Type");
        System.out.println("Content type header is "+header);

        int code= response.statusCode();
        System.out.println("Status code is "+code);
        Assert.assertEquals(code,200);
        Reporter.log("status code is 200");

        String email = response.jsonPath().get("email");
        System.out.println("email  is "+email);
        Assert.assertEquals("jack@gmail.com",email);

        System.out.println( response.getStatusLine());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());

        logger.info("Get user by name");
        Reporter.log("Get user by name");
    }
    @Test
    public void invaliduser(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/user/%40abc");

        int code= response.statusCode();
        System.out.println("Status code is "+code);
        Assert.assertEquals(code,404);

        String message =response.jsonPath().get("message");
        System.out.println("message is "+message);
        Assert.assertEquals("User not found",message);

    }
    @Test
    public void getdeleteduser(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/user/jack");
        int code= response.statusCode();
        System.out.println("Status code is "+code);
        Assert.assertEquals(code,404);


    }

}
