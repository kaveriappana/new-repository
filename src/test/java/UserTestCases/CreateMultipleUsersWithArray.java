package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateMultipleUsersWithArray {
@Test(priority = 1)
    public void createusers() {

    String JsonData ="[\n" +
            "  {\n" +
            "    \"id\": 0,\n" +
            "    \"username\": \"abc\",\n" +
            "    \"firstName\": \"string\",\n" +
            "    \"lastName\": \"string\",\n" +
            "    \"email\": \"abc@gmail.com\",\n" +
            "    \"password\": \"abc\",\n" +
            "    \"phone\": \"123456789\",\n" +
            "    \"userStatus\": 0\n" +
            "  },\n" +
            "{\n" +
            "    \"id\": 0,\n" +
            "    \"username\": \"def\",\n" +
            "    \"firstName\": \"string\",\n" +
            "    \"lastName\": \"string\",\n" +
            "    \"email\": \"def@gmail.com\",\n" +
            "    \"password\": \"def\",\n" +
            "    \"phone\": \"123456789\",\n" +
            "    \"userStatus\": 0\n" +
            "  }\n" +
            "]";
    RestAssured.baseURI ="https://petstore.swagger.io";
    RequestSpecification httprequest = RestAssured.given();
    httprequest.basePath("/v2/user/createWithArray");
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
