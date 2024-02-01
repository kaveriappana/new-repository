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

public class CreateMultipleUsers {
    @Test(dataProvider = "empdataprovider")
    public void createusers(String id, String username,String firstname,String lastname,String email,String pass,String phone,String userStatus)
    {

        RestAssured.baseURI ="https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();

        JSONObject json= new JSONObject();
        json.put("id",id);
        json.put("username",username);
        json.put("firstName",firstname);
        json.put("lastName",lastname);
        json.put("email",email);
        json.put("password",pass);
        json.put("phone",phone);
        json.put("userStatus",userStatus);


        request.header("Content-Type","application/json");
        request.body(json.toJSONString());
        Response response=request.request(Method.POST,"/v2/user");


        String responseBody = response.getBody().asString();
        System.out.println("Response body is " +responseBody);
        Assert.assertTrue(responseBody!=null);


        int code=response.getStatusCode();
        Assert.assertEquals(code,200);

    }
    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException
    {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredTestingProject\\src\\test\\java\\DataDrivenTesting\\Createmultipleusers.xlsx";
        int rownum = XLUtils.getRowCount(path,"UsersTestData");
        int colcount = XLUtils.getCellCount(path, "UsersTestData",1);
        String empdata[][] = new String[rownum][colcount];
        for(int i = 1; i <= rownum; i++)
        {
            for (int j =0 ; j < colcount; j++ )
            {
                empdata[i-1][j] = XLUtils.getCellData(path, "UsersTestData", i, j);
            }
        }
        return(empdata);
    }
}
