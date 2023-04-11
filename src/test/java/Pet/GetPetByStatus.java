package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class GetPetByStatus {
    @Test(priority = 2)
    public void getpetbystatus(){
        Logger logger = Logger.getLogger("GetPetByStatus.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        Reporter.log("This Request is GET ");
        Reporter.log("End point is /v2/pet/findByStatus?status=sold");
        Reporter.log("This End point get pet details by status");

        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/pet/findByStatus?status=sold");

        String body =response.getBody().asString();
        System.out.println("response body is "+body);
        Reporter.log("Response body contains "+body);
        Reporter.log("Status code contains 200");
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("Gets pet details based on status");

    }
}
