package TestUser;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CreateUsers {

    @Test
    public void SuccessCreateUsers(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();
        JSONObject bodyrequest = new JSONObject();
        bodyrequest.put("name", "Lisa Primadani");
        bodyrequest.put("job", "Quality Assurance");


        //addjason
        request.body(bodyrequest.toString());

        //set content
        request.header("Content-type",  "application/json");
        Response response = request.post("/api/users");

        //respon code
        response.then().assertThat().statusCode(201);
        System.out.println(response.asString());


    }

}
