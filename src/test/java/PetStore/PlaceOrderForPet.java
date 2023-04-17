package PetStore;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderForPet {
    @Test(priority = 2)
    public void petorder(){
        RestAssured.baseURI = "https://petstore.swagger.io";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();


        requestParams.put("ID", "2");
        requestParams.put("petId", "0");
        requestParams.put("quantity", "0");
        requestParams.put("shipDate", "2023-03-28T06:48:56.553Z");
        requestParams.put("status", "placed");
        requestParams.put("complete", "true");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST,"/v2/store/order");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);

        response.getTime();
        response.getStatusCode();

    }
    @Test
    public void placleorderbychangingfields(){
        RestAssured.baseURI = "https://petstore.swagger.io";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();


        requestParams.put("ID", "2");
        requestParams.put("petId", "0");
        requestParams.put("quantity", "5");
        requestParams.put("shipDate", "2023-03-28T06:48:56.553Z");
        requestParams.put("status", "placed");
        requestParams.put("complete", "false");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.request(Method.POST,"/v2/store/order");

        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);

        System.out.println(response.getTime());
        System.out.println(response.getStatusCode());
        Assert.assertTrue(responseBody.contains("\"quantity\":5"));
        Assert.assertTrue(responseBody.contains("\"petId\":0"));
    }
}
