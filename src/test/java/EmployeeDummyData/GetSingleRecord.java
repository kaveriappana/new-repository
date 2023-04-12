package EmployeeDummyData;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.util.logging.Logger;
import static io.restassured.RestAssured.baseURI;

public class GetSingleRecord {
    Logger logger = Logger.getLogger("GetSingleRecord.class");
    @Test
    public void getrecord(){

        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        Reporter.log("This is GET Request");
        Reporter.log("End point is/api/v1/employee/1");
        Reporter.log("Response body contains  status as success");
        baseURI="https://dummy.restapiexample.com";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.when().
                header("Content-Type","application/json").
                get(baseURI +"/api/v1/employee/1");
        String responsebody = response.getBody().asString();
        System.out.println("response body is "+responsebody);
        Reporter.log("Response body is :" +"/n" + responsebody);
        Reporter.log("Status code is 200");

        Assert.assertTrue(responsebody.contains("status\":\"success\""));
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("get single record");
    }
    @Test
    public void createemployee(){
        Reporter.log("This is post request");
        Reporter.log("End point is /api/v1/create");

        baseURI = "https://dummy.restapiexample.com";
        RequestSpecification httprequest =RestAssured.given();
        String  requestbody="{\"name\":\"testing1\",\"salary\":\"123\",\"age\":\"23\"}";
        Reporter.log("Request body is :"+"/n"+requestbody);
        Response response = httprequest.when().
                header("Content-Type","application/json").
                body(requestbody).post(baseURI+"/api/v1/create");

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);
        Reporter.log("Response body is :"+"/n"+responsebody);

        int  statuscode = response.getStatusCode();
        System.out.println("Response status code is :"+statuscode);
        Reporter.log("Status code is :"+statuscode);

        logger.info("Employe created");
        Reporter.log("Employe created");
    }
    @Test
    public void Updateuser(){
        Reporter.log("This is put request");
        Reporter.log("End point is /api/v1/update/21");
        baseURI ="https://dummy.restapiexample.com";
        RequestSpecification httprequest =RestAssured.given();
        String requestbody ="{\"name\":\"new\",\"salary\":\"423\",\"age\":\"53\"}";
        Reporter.log("Request body is :"+"/n"+requestbody);

        Response response = httprequest.when().
                header("Content-Type","application/json").
                body(requestbody).put(baseURI+"/api/v1/update/21");

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);
        Reporter.log("Response body is :"+"/n"+responsebody);

        int  statuscode = response.getStatusCode();
        System.out.println("Response status code is :"+statuscode);
        Reporter.log("Status code is :"+statuscode);

        String expecteddata="{\"status\":\"success\",\"data\":{\"name\":\"new\",\"salary\":\"423\",\"age\":\"53\"},\"message\":\"Successfully! Record has been updated.\"}";
        Assert.assertTrue(responsebody.contentEquals(expecteddata));

        String statusline =response.getStatusLine();
        System.out.println("status line is :"+statusline);

       Reporter.log("Employee data updated");
       logger.info("Employe data updated successfully");
    }
    @Test
    public void deleteemployee(){
        Reporter.log("This is Delete request");
        Reporter.log("End point is /public/api/v1/delete/2");
        baseURI ="https://dummy.restapiexample.com";
        RequestSpecification httprequest =RestAssured.given();

        Response response = httprequest.when().
                header("Content-Type","application/json").
                delete(baseURI+"/public/api/v1/delete/2");

        String responsebody = response.getBody().asString();
        System.out.println("Response body is "+responsebody);
        Reporter.log("Response body is :"+"/n"+responsebody);
        int  statuscode = response.getStatusCode();
        System.out.println("Response status code is :"+statuscode);
        Reporter.log("Status code is :"+statuscode);

        String expecteddata ="{\"status\":\"success\",\"data\":\"2\",\"message\":\"Successfully! Record has been deleted\"}";
        Assert.assertTrue(responsebody.contentEquals(expecteddata));

        Reporter.log("Employee deleted successfully");
        logger.info("Employee deleted successfully");
        
    }
}
