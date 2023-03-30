package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleUserNotFound {
    @Test
    public void singleusernotfound(){
        RestAssured.baseURI="https://reqres.in/";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET,"api/unknown/23");

        Assert.assertEquals(response.getStatusCode(),404);

    }
}
