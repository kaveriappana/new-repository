package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class GetPetById {
    @Test(priority = 4)
    public void findpetbyid(){
        Logger logger = Logger.getLogger("GetPetById.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        RestAssured.baseURI ="https://petstore.swagger.io";

        Reporter.log("This request is GET request");
        Reporter.log("End point is /v2/pet/2");
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/pet/2");

        String body =response.getBody().asString();
        System.out.println("response body is "+body);
        Reporter.log("Response body is "+body);

        Assert.assertEquals(response.getStatusCode(),200);
        Reporter.log("Status code is 200");
        Reporter.log("Get pet By Id");
        logger.info("Get pet by Id");
    }
}
