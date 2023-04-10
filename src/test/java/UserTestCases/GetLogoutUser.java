package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class GetLogoutUser {
    @Test(priority = 6)
    public void logout(){
        Logger logger = Logger.getLogger(String.valueOf(CreateUser.class));
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");

        Reporter.log("This is GET request");
        Reporter.log("EndPoint is /v2/user/logout");
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/user/logout");

        logger.info("user logout successful");
        Reporter.log("Status code is");
        Reporter.log(String.valueOf(response.getStatusCode()));
        System.out.println("user logout succesfully by status code is "+response.getStatusCode());

        Reporter.log("User logout successful");
    }
}
