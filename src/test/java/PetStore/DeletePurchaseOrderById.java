package PetStore;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePurchaseOrderById {
    @Test(priority = 4)
    public void deletepurchasebyid() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.DELETE, "/v2/store/order/2");

        int code = response.statusCode();
        System.out.println("Status code " + code);
        Assert.assertEquals(code, 200);
    }
    @Test
    public void deletealreadydeletedpurchase(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response = request.request(Method.DELETE, "/v2/store/order/7");

        int code = response.statusCode();
        System.out.println("Status code " + code);
        Assert.assertEquals(code, 404);
    }
}
