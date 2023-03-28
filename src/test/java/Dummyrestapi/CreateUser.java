package Dummyrestapi;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CreateUser {
    @Test
    public void createuser() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httprequest = RestAssured.given();
        httprequest.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("name", "morpheus");
        json.put("job", "leader");

        httprequest.body(json.toJSONString());
        Response response = httprequest.request(Method.POST, "/api/users");

        String body = response.getBody().asString();
        System.out.println("request body " + body);

        System.out.println(response.getStatusCode());

    }
}
