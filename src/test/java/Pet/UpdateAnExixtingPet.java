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

public class UpdateAnExixtingPet {
    @Test(priority = 5)
    public void updatepet(){
        Logger.getLogger("UpdateAnExistingPet.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        Reporter.log("This is PUT request");
        Reporter.log("End point is /v2/pet");

        String JsonData ="{\n" +
                "  \"id\": 11,\n" +
                "  \"category\": {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"cats\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest = RestAssured.given();
        httprequest.basePath("/v2/pet");
        httprequest.header("Content-Type","application/json");
        Reporter.log("Header content-type is application/json");
        httprequest.body(JsonData);

        Response response = httprequest.put();

        String requestbody= response.getBody().asString();
        System.out.println("request body is "+requestbody);
        Reporter.log("Response body contains "+requestbody);


        Assert.assertEquals(response.getStatusCode(),200);
        Reporter.log("Status code is 200");
        System.out.println(response.getStatusCode());

    }
    @Test()
    public void updatethepetinformationbyid(){

        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.request(Method.PUT,"/v2/pet/2");
        Reporter.log("End point as /v2/pet/2");
        Reporter.log("Status code is 200");
        Assert.assertEquals(response.getStatusCode(),200);

        String responsebody= response.getBody().asString();
        System.out.println("response body is "+responsebody);
        Reporter.log("Response body is "+responsebody);

        JsonPath jsonpath = response.jsonPath();
        System.out.println((String) jsonpath.get("type"));
        Assert.assertEquals(jsonpath.get("type"),"unknown");
        Reporter.log("Response body contains header type as unknown");


    }

}
