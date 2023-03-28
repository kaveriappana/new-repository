package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class FindPurchaseOrder_DataDriven {
    @Test(dataProvider = "empdataprovider")
    public void getpet(String id){
        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        Response response= request.request(Method.GET,"/v2/pet/"+id);
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("Content-Type"));

        int code =response.statusCode();
        System.out.println("Status code is "+code);
        Assert.assertEquals(code,200);
    }
    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException
    {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredTestingProject\\src\\main\\resources\\PetStoreTestData.xlsx";
        int rownum = XLUtils.getRowCount(path,"PetStoreTestData");
        int colcount = XLUtils.getCellCount(path, "PetStoreTestData",1);
        String empdata[][] = new String[rownum][colcount];
        for(int i = 1; i <= rownum; i++)
        {
            for (int j =0 ; j < colcount; j++ )
            {
                empdata[i-1][j] = XLUtils.getCellData(path, "PetStoreTestData", i, j);
            }
        }
        return(empdata);
    }
}
