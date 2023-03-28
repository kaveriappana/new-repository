package PetStore;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetInventoryStatus {
    @Test(priority = 1)
    public void inventory() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();

        Response response = request.request(Method.GET, "v2/store/inventory");

        int status = response.getStatusCode();
        System.out.println("status code is " + status);
        Assert.assertEquals(status, 200);

        String statusmessage = response.getStatusLine();
        System.out.println("status massage :" + statusmessage);

        System.out.println(response.getTime());
        String content = response.getHeader("Content-Type");
        System.out.println("content type is " + content);
        Assert.assertEquals(content, "application/json");

        System.out.println(response.getBody().asString());

    }
    }
