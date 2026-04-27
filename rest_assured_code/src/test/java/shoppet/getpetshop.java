package shoppet;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class getpetshop {


    String baseURI;
    String path = "/v2/store/order";
    String invalid = "abc";




    @BeforeClass
    void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;

    }

    @Test
    void test_01(){

        System.out.println("getdijalankan ");

        int orderid = postshop.createorderid;

        System.out.println("Fetching Order ID: " + orderid);

        given().baseUri(baseURI)
                .pathParams("orderid", orderid)
                .when()
                .get(path +"/{orderid}")
                .then()
                .statusCode(200)
                .log().all();
    }


    @Test
    void tets_02(){


        System.out.println("Trying to fetch with ID: " + invalid);
        given().baseUri(baseURI)
                .pathParams("invalid", invalid)
                .when()
                .get(path + "/{invalid}")
                .then()
                .statusCode(400)
                .log().all()
                .body("message",containsString("invalid"));
    }

}
