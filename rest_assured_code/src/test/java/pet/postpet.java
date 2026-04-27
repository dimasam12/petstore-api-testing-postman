package pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;
import petdata.datapet;

public class postpet {

    String baseURI;
    String content = "application/json";
    String path = "/v2/pet";

    datapet pet;
    datapet emptypet;

    @BeforeClass
    void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        baseURI = RestAssured.baseURI;

//        membuat objek
        pet = new datapet();
        pet.id = 1;

        datapet.Kategori kategori = new datapet.Kategori();
        kategori.id = 1;
        kategori.nama = "hewan peliharaan";
        pet.kategori = kategori;

        pet.name = "kucing";

        // Buat list photourl (opsional)
        pet.photourl = java.util.Arrays.asList("kucing.jpg");

        // Buat list tags
        datapet.Tag tag = new datapet.Tag();
        tag.id = 1;
        tag.name = "kucing lucu";
        pet.tags = java.util.Arrays.asList(tag);

        pet.status = "pending";

        // ===== MEMBUAT OBJECT PET KOSONG =====
        emptypet = new datapet();
        emptypet.id = 0;

        datapet.Kategori emptyKategori = new datapet.Kategori();
        emptyKategori.id = 0;
        emptyKategori.nama = "";
        emptypet.kategori = emptyKategori;

        emptypet.name = "";
        emptypet.status = "";
    }

    @Test
    void test_01() {
        given()
                .baseUri(baseURI)
                .body(pet)  // pakai pet yang sudah di-setup
                .header("Content-Type", content)
                .log().all()
                .when()
                .post(path)
                .then()
                .statusCode(200)
                .body("name", equalTo("kucing"))  //
                .body("status", equalTo("pending"))
                .log().all();
    }

    @Test
    void test_02() {
        given()
                .baseUri(baseURI)
                .body(emptypet)
                .header("Content-Type", content)
                .log().all()
                .when()
                .post(path)
                .then()
                .log().all()
                .statusCode(400);
    }
}