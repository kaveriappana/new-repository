package EmployeeDummyData;

import io.restassured.RestAssured;
import  static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewEmploye {
    @Test
    public void createemploye(){
        RestAssured.baseURI="https://dummy.restapiexample.com";
       String response = given().log().all().header("Content-Type","application/json").
                body("{\"name\":\"testing\",\"salary\":\"123\",\"age\":\"23\"}").
                when().post("/api/v1/create").
                then().assertThat().statusCode(200).extract().body().asString();
       System.out.println("Response body is : "+response);

        JsonPath json = new JsonPath(response);

        String status =json.getString("status");
        System.out.println("status value is : "+status);
        Assert.assertEquals(status,"success");

        String message = json.getString("message");
        System.out.println("Message is : "+message);
        Assert.assertEquals(message,"Successfully! Record has been added.");

        Assert.assertTrue(response.contains("\"name\":\"testing\""));
        Assert.assertTrue(response.contains("\"salary\":\"123\""));

        Assert.assertTrue(response.contains("\"age\":\"23\""));


    }
}
