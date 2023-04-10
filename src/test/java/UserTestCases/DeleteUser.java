package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class DeleteUser {
    @Test(priority = 7)
    public void deleteuser(){
        Logger logger = Logger.getLogger("DeleteUser.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");

        Reporter.log("This request is DELETE ");
        Reporter.log("End point is https://petstore.swagger.io/v2/user/jack");
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("https://petstore.swagger.io/v2/user/jack");
        int code = response.getStatusCode();
        System.out.println("status code" +code);
        Assert.assertEquals(code,200);
        logger.info("User is deleted");
        Reporter.log("Status code is 200");
        Reporter.log("Sser deleted successfully");
    }
    @Test
    public void deletedeleteduser(){
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("https://petstore.swagger.io/v2/user/jjack");
        Reporter.log("Delete already deleted user");
        int code = response.getStatusCode();
        System.out.println("status code" +code);
        Assert.assertEquals(code,404);
        Reporter.log("Status code is 404");
        Reporter.log("user deleted successfully");
    }
}
