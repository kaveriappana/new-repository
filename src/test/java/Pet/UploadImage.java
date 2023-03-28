package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadImage {
    @Test(priority = 3)
    public void uploadimage(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.request(Method.POST,"/v2/pet/12/uploadImage");

        String responsebody=response.getBody().asString();
        System.out.println("response body is"+responsebody);

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),415);
    }
}
