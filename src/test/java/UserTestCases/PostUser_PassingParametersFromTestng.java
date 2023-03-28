package UserTestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PostUser_PassingParametersFromTestng {
    @Parameters({"id","username","firstName","lastName","email","password","phone","userStatus"})
    @Test
    public void createuser(int id,String username,String firstName,String lastname,String email,String password,String phone,String userStatus){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("id",id);
        json.put("username",username);
        json.put( "firstName",firstName);
        json.put("lastName",lastname);
        json.put("email",email);
        json.put("password",password);
        json.put("phone",phone);
        json.put("userStatus",userStatus);

        request.body(json.toJSONString());
        Response response =request.post("https://petstore.swagger.io/v2/user");

        int code = response.getStatusCode();
        System.out.println("status code :"+code);

        String data = response.asString();
        System.out.println("Data is" +data);

        Assert.assertEquals(code,200);

    }
}

