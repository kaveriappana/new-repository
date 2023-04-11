package Pet;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class AddNewPetToStore {
    @Test(priority = 1)
    public void addpet(){
        Logger logger =Logger.getLogger("Pet.AddNewPetToStore");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        String JsonData ="{\n" +
                "  \"id\": 2,\n" +
                "  \"category\": {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"dog\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest = RestAssured.given();
        Reporter.log("This is post request");
        Reporter.log("Request body contains id,name,category,photoUrls,status");
        httprequest.basePath("/v2/pet");
        Reporter.log("End point is /v2/pet");
        httprequest.header("accept","application/json");
        Reporter.log("This Response body contains a header accept as application/json");
        httprequest.header("Content-Type","application/json");
        Reporter.log("Header Content-Type as application/json");
        httprequest.body(JsonData);

        Response response = httprequest.post();

        String responsebody= response.getBody().asString();
        System.out.println("request body is "+responsebody);
        Reporter.log("Response body is "+responsebody);


        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getStatusCode());
        Reporter.log("Status code is 200");

        logger.info("A new pet is created ");
        Reporter.log("A new pet is created");

    }

}
