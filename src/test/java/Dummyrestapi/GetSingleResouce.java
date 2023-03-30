package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleResouce {
    @Test
    public void getsingleuser(){
        RestAssured.baseURI ="https://reqres.in";
        RequestSpecification httprequest=RestAssured.given();
        Response response = httprequest.request(Method.GET,"/api/unknown/2");

        String responsebody =response.getBody().asString();
        System.out.println("response body "+responsebody);

        String expected ="{\"data\":{\"id\":2,\"name\":\"fuchsia rose\",\"year\":2001,\"color\":\"#C74375\",\"pantone_value\":\"17-2031\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}";
        Assert.assertTrue(responsebody.contentEquals(expected));


    }

}
