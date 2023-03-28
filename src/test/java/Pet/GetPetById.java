package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPetById {
    @Test(priority = 4)
    public void findpetbyid(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request =RestAssured.given();
        Response response = request.request(Method.GET ,"/v2/pet/2");

        String body =response.getBody().asString();
        System.out.println("response body is "+body);

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
