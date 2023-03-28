package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateUserDummyrestapi_DataDriven {
    @Test(dataProvider = "empdataprovider")
    public void postemlopyees(String ename, String esal, String eage){
        RestAssured.baseURI ="https://dummy.restapiexample.com";
        RequestSpecification request = RestAssured.given();

        JSONObject json= new JSONObject();
        json.put("name",ename);
        json.put("salary",esal);
        json.put("age",eage);

        request.header("Content-Type","application/json");
        request.body(json.toJSONString());
        Response response=request.request(Method.POST,"/api/v1/create");


        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);

        Assert.assertEquals(responseBody.contains(ename),true);
        Assert.assertEquals(responseBody.contains(esal),true);
        Assert.assertEquals(responseBody.contains(eage),true);

        int code=response.getStatusCode();
        Assert.assertEquals(code,200);

    }
    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException
    {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredTestingProject\\src\\main\\resources\\dummyrestapiData.xlsx";
        int rownum = XLUtils.getRowCount(path,"dummyrestapiData");
        int colcount = XLUtils.getCellCount(path, "dummyrestapiData",1);
        String empdata[][] = new String[rownum][colcount];
        for(int i = 1; i <= rownum; i++)
        {
            for (int j =0 ; j < colcount; j++ )
            {
                empdata[i-1][j] = XLUtils.getCellData(path, "dummyrestapiData", i, j);
            }
        }
        return(empdata);
    }
}
