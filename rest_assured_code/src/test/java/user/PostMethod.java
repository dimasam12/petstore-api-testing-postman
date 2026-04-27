package user;

import org.testng.annotations.Test;
import Userdata.userdata;

import static io.restassured.RestAssured.given;

public class PostMethod {

    @Test
    void Test_01() {

        userdata user = new userdata();

        user.id = 0;
        user.username = "dimasam12";
        user.firstname = "dimas";
        user.lastname = "maulana";
        user.email = "dimasakbar481@gmail.com";
        user.password = "dimasam1207";
        user.phone = "081272700900";
        user.userStatus = 1;

        given()
                .baseUri("https://petstore.swagger.io")
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("/v2/user")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    void Test_02(){
        userdata user = new userdata();
        user. id = 1;
        user. username = "";
        user. firstname = "";
        user. lastname = "";
        user. email = "";
        user. password = "";
        user. phone = "";
        user.userStatus = 1;

        given()
                .baseUri("https://petstore.swagger.io")
                .header("Content-Type", "application/json")
                .body(user)
                .when().post("/v2/user")
                .then()
                .log().all()
                .statusCode(400);


    }

    @Test
    void Test_03 (){
        userdata user = new userdata();

        given()
                .baseUri("https://petstore.swagger.io")
                .body("")
//                .header("Content-Type", "application/x-www-form-urlencoded")
                .when()
                .post("/v2/user")
                .then()
                .log().all()
                .statusCode(415);

        }
    }

