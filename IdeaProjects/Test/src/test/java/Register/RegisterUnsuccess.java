package Register;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RegisterUnsuccess {
    @Test
    public void RegisGagal(ITestContext context){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = given();

        //json object
        JSONObject bodyrequest = new JSONObject();
        bodyrequest.put("email", "lissa1@majoo.id");
        bodyrequest.put("password", "lissa123");


        //addjason
        request.body(bodyrequest.toString());

        //set content
        request.header("Content-type",  "application/json");
        Response response = request.post("/api/register");
        String schemaPath = "src/resource/RegisterUnsuccess.json";

        //respon code
        response.then().assertThat()
                .statusCode(400)
                .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath)));
        System.out.println(response.asString());


    }
}
