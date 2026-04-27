package pet;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class deletepet {

    String baseURI;
    String path = "/v2/pet";
    int id = 1 ;

    @BeforeClass
    void setup (){
        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;

    }

    @Test
    void test_01(){
        given().baseUri(baseURI)
                .pathParams("id", id)
                .log().all()
                .when()
                .delete(path + "/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }


}
