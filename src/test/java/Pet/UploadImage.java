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

public class UploadImage {
    @Test(priority = 3)
    public void uploadimage(){
        Logger.getLogger("UploadImage");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        Reporter.log("This Request is POST");
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.request(Method.POST,"/v2/pet/12/uploadImage");
        Reporter.log("Endpoint is /v2/pet/12/uploadImage");

        String responsebody=response.getBody().asString();
        System.out.println("response body is"+responsebody);
        Reporter.log("Response body is "+responsebody);

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),415);
        Reporter.log("Status code is 415");
    }
}
