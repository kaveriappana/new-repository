package Pet;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewPetToStore {
    @Test(priority = 1)
    public void addpet(){
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
        httprequest.basePath("/v2/pet");
        httprequest.header("accept","application/json");
        httprequest.header("Content-Type","application/json");
        httprequest.body(JsonData);

        Response response = httprequest.post();

        String requestbody= response.getBody().asString();
        System.out.println("request body is "+requestbody);


        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getStatusCode());

    }

}
