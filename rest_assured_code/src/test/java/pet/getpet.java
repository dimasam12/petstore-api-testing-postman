package pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;

public class getpet {

    String baseURI;
    String path = "/v2/pet";
    int id = 1;
    int inid = 2000;

    @BeforeClass
    void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;
    }

    @Test
    void test_01(){
        given()
                .baseUri(baseURI)
                .pathParams("petid", id )
                .log().all()
                .when()
                .get(path + "/{petid}")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void test_02(){
        given()
                .baseUri(baseURI)
                .pathParams("petid", inid )
                .log().all()
                .when()
                .get(path + "/{petid}")
                .then()
                .statusCode(404)
                .log().all();
    }
    @Test
    void test_03(){
        given()
                .baseUri(baseURI)
                .queryParam("status", "pending")
                .log().all()
                .when()
                .get(path + "/findByStatus")
                .then()
                .statusCode(200)
                .body("[1].status", equalTo("pending"))
                .log().all();
    }

    @Test
    void test_04() {
        given()
                .baseUri(baseURI)
                .queryParam("status", "pending")
                .log().all()
                .when()
                .get(path + "/findByStatus")
                .then()
                .statusCode(200)
                .body("[99].status", equalTo("pending"))
                .log().all();
    }

}
