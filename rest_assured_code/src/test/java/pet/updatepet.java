package pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import java.util.Arrays;
import petdata.datapet;
public class updatepet {

    String baseURI;
    String path = "/v2/pet";
    String conten = "application/json";
    datapet pet;
    datapet emptypet;

    @BeforeClass
    <pet>
    void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;
        pet = new datapet();
        pet.id = 1;
        pet.name = "kucingpersia";

        datapet.Kategori category = new datapet.Kategori();
        category.id = 1;
        category.nama = "Kucing";
        pet.kategori = category;
        pet.status = "sold";

//        objek kosong

        emptypet = new  datapet();
        emptypet.id = 0;
        emptypet.name = "";
        emptypet.status = "";


    }

    @Test
    void test_01(){
        given()
                .baseUri(baseURI)
                .body(pet)
                .header("Content-Type", conten)
                .log().all()
                .when()
                .put(path)
                .then()
                .statusCode(200)
                .body("name", equalTo("kucingpersia"))
                .log().all();
    }

    @Test
    void test_02(){
        given()
                .baseUri(baseURI)
                .header("Content-type",conten)
                .body(emptypet)
                .when()
                .put(path)
                .then()
                .statusCode(400)
                .log().all()
                .body("message", equalTo("bad input"))
                .body("status", equalTo("sold"));
    }


}
