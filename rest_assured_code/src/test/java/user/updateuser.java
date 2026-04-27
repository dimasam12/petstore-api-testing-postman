package user;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class updateuser {
    Map<String, Object> emptyUserData = new HashMap<>();
    Map<String, Object> userdata = new HashMap<>();
    String baseURI;
    String contentType = "application/json";
    String path = "/v2/user/";

    @BeforeClass
    void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;

        userdata.put("id", 1);
        userdata.put("username", "dimas1");
        userdata.put("password", "password123");
        userdata.put("firstname", "dimas");
        userdata.put("lastname", "testing");
        userdata.put("email", "dimas@test.com");
        userdata.put("phone", "08123456789");
        userdata.put("userStatus", 1);



        emptyUserData.put("id", "");
        emptyUserData.put("username", "");
        emptyUserData.put("password", "");
        emptyUserData.put("firstname", "");
        emptyUserData.put("lastname", "");
        emptyUserData.put("email", "");
        emptyUserData.put("phone", "");
        emptyUserData.put("userStatus", "");
    }

    @Test
    void Test_01() {
        given()
                .baseUri(baseURI)
                .body(userdata)
                .header("Content-Type", contentType)
                .log().all()
                .when()
                .put(path + "dimas1")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    void Test_02(){
        given()
                .baseUri(baseURI)
                .body(emptyUserData)
                .header("Content-Type", contentType)
                .log().all()
                .when()
                .put(path + "dimas1")
                .then()
                .log().all()
                .statusCode(400)
                .body("message", equalTo("bad input"));
    }

}