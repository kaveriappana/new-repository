package PetStore;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindPurchaseByOrderId {
    @Test(priority = 3)
    public void getpet(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response= request.request(Method.GET,"/v2/pet/2");
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("Content-Type"));

        int code =response.statusCode();
        System.out.println("Status code is "+code);
        Assert.assertEquals(code,200);
    }
    @Test
    public void getpetbyinalidid(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response= request.request(Method.GET,"/v2/pet/8");
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("Content-Type"));

        int code =response.statusCode();
        System.out.println("Status code is "+code);
        Assert.assertEquals(code,404);
    }
}
