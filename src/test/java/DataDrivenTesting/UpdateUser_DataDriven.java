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

public class UpdateUser_DataDriven {
    @Test(dataProvider = "empdataprovider")
    public void updateuser(String username,String firstName,String lastName,String email,String password,String phone) {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id", "0");
        json.put("username", username);
        json.put("firstName", firstName);
        json.put("lastName", lastName);
        json.put("email", email);
        json.put("password", password);
        json.put("phone", phone);
        json.put("userStatus", "0");

        request.body(json.toJSONString());
        Response response = request.request(Method.PUT, "/v2/user/jack");

        Assert.assertEquals(response.getStatusCode(), 200);

        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());

    }

    @DataProvider(name = "empdataprovider")
    @Test(retryAnalyzer = RetryAnalizer.class)
    String[][] getEmpData() throws IOException {
        String path = "C:\\Users\\kaveri.appana\\IdeaProjects\\RestAssuredTestingProject\\src\\main\\resources\\UsersTestData.xlsx";
        int rownum = XLUtils.getRowCount(path, "UsersTestData");
        int colcount = XLUtils.getCellCount(path, "UsersTestData", 1);
        String empdata[][] = new String[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                empdata[i - 1][j] = XLUtils.getCellData(path, "UsersTestData", i, j);
            }
        }
        return (empdata);
    }
}
