package RoutersAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class GetRequest {
    @Test
    public void getrequest(){
        Logger logger = Logger.getLogger("GetRequest.class");
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        Reporter.log("This is get Request");
        Reporter.log("End point is /posts");
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.header("Content-Type","Application/json").when()
                .get("/posts");
        int code = response.getStatusCode();
        System.out.println("Status code is : "+code);
        Assert.assertEquals(code,200);
        Reporter.log("Status code is: "+code);

        String responsebody = response.getBody().asString();
        System.out.println("Response body is : "+responsebody);
        Reporter.log("Response body is : "+responsebody);

        JsonPath js = new JsonPath(responsebody);
        String title = js.getString("title");
        System.out.println("Title is : "+title);

        int count = js.getInt("userId.size()");
        System.out.println("count is : "+count);

        for(int i =0;i<count;i++){
            String userid = js.getString("userId");
            System.out.println(userid);
        }
        logger.info("This is Get Request");
    }
    @Test
    public void getsingleuser(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.header("Content-Type","Application/json").when()
                .get("/posts/1");
        int code = response.getStatusCode();
        System.out.println("Status code is : "+code);
        Assert.assertEquals(code,200);

        String responsebody = response.getBody().asString();
        System.out.println("Response body is : "+responsebody);

        JsonPath json = new JsonPath(responsebody);
        String title = json.getString("title");
        System.out.println("Title is :"+title);
        String body = json.getString("body");
        System.out.println("Body is : "+body);
        int id = json.getInt("id");
        System.out.println("id is :"+id);
        Assert.assertEquals(id,1);
        int userid = json.getInt("userId");
        Assert.assertEquals(userid,1);
        Assert.assertTrue(responsebody.contains(" \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\","));

    }
    @Test
    public void getcomments(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.header("Content-Type","Application/json").when()
                .get("/posts/1/comments");
        int code = response.getStatusCode();
        System.out.println("Status code is :"+code);
        Assert.assertEquals(code,200);
        String responsebody = response.getBody().asString();
        System.out.println("Response body is : "+responsebody);

        JsonPath json1 =new JsonPath(responsebody);
        String name = json1.getString("name");
        System.out.println("name is :"+name);

        String email = json1.getString("email");
        System.out.println("email is :"+email);
        String  time = String.valueOf(response.getTime());
        System.out.println("response time is :"+time);
    }
    @Test
    public void getcommandsandpostid(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.header("Content-Type","Application/json").when()
                .get("/comments?postId=1");
        int code = response.getStatusCode();
        System.out.println("Status code is :"+code);
        Assert.assertEquals(code,200);
        String responsebody = response.getBody().asString();
        System.out.println("Response body is : "+responsebody);
        Assert.assertTrue(responsebody.contains("\"name\": \"id labore ex et quam laborum\""));
        Assert.assertTrue(responsebody.contains("\"postId\": 1"));
        String statusline = response.getStatusLine();
        System.out.println("statusline is :"+statusline);
        Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
    }
}
