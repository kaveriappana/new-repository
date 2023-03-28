package DataDrivenTesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserLogin_DataDriven {
    @Test(dataProvider = "empdataprovider")
    public void getlogin(String username,String password){
    RestAssured.baseURI ="https://petstore.swagger.io";
    RequestSpecification request = RestAssured.given();
    Response response = request.request(Method.GET,"/v2/user/login?username="+username+"&password="+password);

    int statuscode =response.getStatusCode();
        System.out.println("Status code is "+statuscode);
        Assert.assertEquals(statuscode,200);

    String type = response.jsonPath().get("type");
        System.out.println("type is "+type);
        Assert.assertEquals("unknown",type);

    String statusline=response.getStatusLine();
        System.out.println("Status line "+statusline);

        response.getTime();

       String content =response.getHeader("Content-Type");
        System.out.println("content type is " +content);
        Assert.assertEquals(content,"application/json");

}
    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException
    {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredTestingProject\\src\\main\\resources\\user.xlsx";
        int rownum = XLUtils.getRowCount(path,"user");
        int colcount = XLUtils.getCellCount(path, "user",1);
        String empdata[][] = new String[rownum][colcount];
        for(int i = 1; i <= rownum; i++)
        {
            for (int j =0 ; j < colcount; j++ )
            {
                empdata[i-1][j] = XLUtils.getCellData(path, "user", i, j);
            }
        }
        return(empdata);
    }
}
