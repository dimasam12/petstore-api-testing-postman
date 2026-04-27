package user;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class getrequest{
    @BeforeClass
    void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io";

    }

    private void assertequals(String username, String responseUsername) {
    }


    String username = "dimasam12";
    String password = "dimasam1207";
    String invusername = "dimas1";
    String inv2username = "";
    String invpassword = "dimas12";
    String endpoint = "/v2/user/login";
    String endpoint2 = "/v2/user/";    @Test
    void  test_01 (){
        String responbody = given()
                .queryParam("username", username)
                .queryParam("password",password)
                .baseUri("https://petstore.swagger.io")
                .accept("application/json")
                .when()
                .get("/v2/user/login")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .asString();

        System.out.println("body:" + responbody);
    }

    @Test
    void test_02(){
        String ResponseUsername = given() .pathParams("username", username)
                .when()
                .get("/v2/user/{username}")
                .then()
                .statusCode(200)
                .extract()
                .path("username");
        System.out.println("username yang diminta" + username);
        System.out.println("response body" + ResponseUsername);

        assertequals(username,ResponseUsername);
    }

    @Test
    void test_03(){
        given().baseUri(baseURI)
                .queryParam("username", "")
                .queryParam("password", "")
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(400)
                .body("code", equalTo(400));
    }

    @Test
    void test_04(){
        given().baseUri(baseURI)
                .pathParams("invusername", invusername)
                .log().all()
                .when()
                .get("/v2/user/{invusername}")
                .then()
                .log().all()
                .statusCode(404)
                .body("code", equalTo(404))
                .body("message", equalTo("User not found"));
    }

    @Test
    void test_05(){
        given().baseUri(baseURI)
                .log().all()
                .when()
                .get(endpoint2)
                .then()
                .log().all()
                .statusCode(405);
    }


}
