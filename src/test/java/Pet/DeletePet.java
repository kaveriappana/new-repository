package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class DeletePet {
    @Test(priority = 6)
    public void deletepet(){
        Logger logger = Logger.getLogger("DeletePet");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        RestAssured.baseURI ="https://petstore.swagger.io";
        Reporter.log("This is DELETE Request");
        Reporter.log("End point is /v2/pet/2");

        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.request(Method.DELETE,"/v2/pet/2");
        Assert.assertEquals(response.getStatusCode(),200);
        Reporter.log("Status code is 200");
        logger.info("Delete the pet by id");



    }
}
