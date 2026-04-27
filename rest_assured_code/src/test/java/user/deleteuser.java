package user;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.Argument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class deleteuser {

    private static final Logger log = LoggerFactory.getLogger(deleteuser.class);
    String baseURI;
    String path = "/v2/user/";
    private List<Argument> equalsTO;

    @BeforeClass
    void setup (){
        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;

    }

    @Test
    void test_01 (){
        given()
                .baseUri(baseURI)
                .log().all()
                .when()
                .delete(path + "dimas12")
                .then()
                .log().all()
                .statusCode(404);

    }


    @Test
    void test_02(){
        given()
                .baseUri(baseURI)
                .log().all()
                .when()
                .delete(path + "dimas1")
                .then()
                .log().all()
                .statusCode(200);
    }


}