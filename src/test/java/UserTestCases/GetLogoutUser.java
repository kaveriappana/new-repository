package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class GetLogoutUser {
    @Test(priority = 6)
    public void logout(){
         Logger logger = Logger.getLogger(String.valueOf(GetLogoutUser.class));
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/user/logout");

        Reporter.log("user is deleted");
        logger.info("user is deleted");
        System.out.println("user logout succesfully by status code is "+response.getStatusCode());


    }
}
