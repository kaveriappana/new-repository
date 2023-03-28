package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPetByStatus {
    @Test(priority = 2)
    public void getpetbystatus(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/pet/findByStatus?status=sold");

        String body =response.getBody().asString();
        System.out.println("response body is "+body);

        Assert.assertEquals(response.getStatusCode(),200);

    }
}
