package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewPet_DataDriven {
    @Test(dataProvider = "empdataprovider")
    public void addpet(String requestbody) {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecification httprequest = RestAssured.given();

        httprequest.header("accept","application/json");
        httprequest.header("Content-Type","application/json");

        Response response = httprequest.when().body(requestbody).post(RestAssured.baseURI+"/v2/pet");
        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);


    }
    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException
    {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredTestingProject\\src\\main\\resources\\PetTestData.xlsx";
        int rownum = XLUtils.getRowCount(path,"PetTestData");
        int colcount = XLUtils.getCellCount(path, "PetTestData",0);
        String empdata[][] = new String[rownum][colcount];
        for(int i = 1; i <= rownum; i++)
        {
            for (int j =0 ; j < colcount; j++ )
            {
                empdata[i-1][j] = XLUtils.getCellData(path, "PetTestData", i, j);
            }
        }

        return(empdata);
    }
}
