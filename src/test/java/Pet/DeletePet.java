package Pet;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePet {
    @Test(priority = 6)
    public void deletepet(){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification httprequest =RestAssured.given();
        Response response =httprequest.request(Method.DELETE,"/v2/pet/2");
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
