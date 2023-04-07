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

public class CreateEmploye_DataDriven {
    Logger logger = Logger.getLogger("CreateEmploye_DataDriven.class");
    @Test(dataProvider = "empdataprovider")
    public void createemployee(String name, String salary, String age) {
        PropertyConfigurator.configure("C:\\Users\\kaveri.appana\\IdeaProjects\\new-repository\\src\\main\\resources\\log4j.properties");
        RestAssured.baseURI = "https://dummy.restapiexample.com";
        RequestSpecification httprequest = RestAssured.given();
        httprequest.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("salary", salary);
        json.put("age", age);

        httprequest.body(json.toJSONString());
        Response response = httprequest.request(Method.POST, "/api/v1/create");

        String respbody = response.getBody().asString();
        System.out.println("response body " + respbody);

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertTrue(respbody.contains("\"status\":\"success\""));
        logger.info("created  employe");
        Reporter.log("created employe");
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
