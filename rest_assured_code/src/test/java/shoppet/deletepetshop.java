package shoppet;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;


public class deletepetshop {


    String baseURI;
    String path = "/v2/store/order";
    String invalid = "@@@@";

    @BeforeClass
    void setup (){
        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;


    }

    @Test
    void test_01(){

        int orderid = postshop.createorderid;
        System.out.println("cari order id " + orderid);
        given(). baseUri(baseURI)
                .pathParams("orderid", orderid)
                .log().all()
                .when()
                .delete(path + "/{orderid}")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void test_2(){
        System.out.println("mencari id" + invalid);
        given().baseUri(baseURI)
                .pathParams("invalid", invalid)
                .when()
                .delete(invalid + "/{invalid}")
                .then()
                .statusCode(400)
                .log().all();
    }

}
