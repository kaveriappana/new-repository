package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateAnExixtingPet {
    @Test(priority = 5)
    public void updatepet(){
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
        httprequest.body(JsonData);

        Response response = httprequest.put();

        String requestbody= response.getBody().asString();
        System.out.println("request body is "+requestbody);


        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println(response.getStatusCode());

    }
    @Test
    public void updatethepetinformationbyid(){

        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.request(Method.POST,"/v2/pet/2");
        Assert.assertEquals(response.getStatusCode(),200);

        String requestbody= response.getBody().asString();
        System.out.println("request body is "+requestbody);


        JsonPath jsonpath = response.jsonPath();
        System.out.println((String) jsonpath.get("type"));
        Assert.assertEquals(jsonpath.get("type"),"unknown");


    }

}
