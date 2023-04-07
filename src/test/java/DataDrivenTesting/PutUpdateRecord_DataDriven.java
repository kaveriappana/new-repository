package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class PutUpdateRecord_DataDriven {
    Logger logger = Logger.getLogger("PutUpdateRecord_DataDriven.class");
    @Test(dataProvider = "empdataprovider")
    public void updateuser(String name, String salary, String age) {
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        RestAssured.baseURI = "https://dummy.restapiexample.com";
        RequestSpecification httprequest = RestAssured.given();

        httprequest.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();

        json.put("name", name);
        json.put("salary", salary);
        json.put("age", age);

        httprequest.body(json.toJSONString());
        Response response = httprequest.request(Method.PUT, "/api/v1/update/21");

        int code = response.statusCode();
        System.out.println("Status code is " + code);
        logger.info("updated user status code is 200");
        String responsebody = response.getBody().asString();
        System.out.println("Response body is " + responsebody);

        Assert.assertEquals(code, 200);
        Assert.assertTrue(responsebody.contains("\"status\":\"success\""));
        Reporter.log("updated user");
    }
    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException
    {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\reqres.xlsx";
        int rownum = XLUtils.getRowCount(path,"reqres");
        int colcount = XLUtils.getCellCount(path, "reqres",0);
        String empdata[][] = new String[rownum][colcount];
        for(int i = 1; i <= rownum; i++)
        {
            for (int j =0 ; j < colcount; j++ )
            {
                empdata[i-1][j] = XLUtils.getCellData(path, "reqres", i, j);
            }
        }

        return(empdata);
    }
}
