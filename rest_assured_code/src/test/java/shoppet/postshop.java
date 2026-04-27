package shoppet;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import storepet.petstore;






public class postshop {

    String baseURI;
    String path = "v2/store/order";
    String head = "application/json";

    petstore pet;
    petstore emptypet;

    public static int createorderid;

    Response response;

    @BeforeClass
    void setup (){

        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;

//        membuat objek
    pet  = new petstore();
    pet.id = 1;
    pet.quantity = 30;
    pet.shipdate = "2026-04-04T01:51:04.540Z";
    pet.status = "placed";
    pet.completed = true;

    emptypet = new petstore();
    emptypet.id = 2;
    emptypet.quantity = 99999999999999L;
    emptypet.shipdate = "2026-04-04T01:51:04.540Z";
    emptypet.status = "order";
    emptypet.completed = true;


    }

    @Test
    void test_01(){
        System.out.println("postdijalanka ");
       response = given().baseUri(baseURI)
                .header("Content-type", head)
                .body(pet)
                .log().all()
                .when()
                .post(path);

        response.then()
                .statusCode(200)
                .log().all()
                .body("quantity", equalTo(30));

        createorderid = response.jsonPath().getInt("id");
        System.out.println("createorderid" + createorderid);
    }

    @Test
    void test_02(){
        given().baseUri(baseURI)
                .header("Content-type", head)
                .body(emptypet)
                .log().all()
                .when()
                .post(path)
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo("bad request"));
    }
}
