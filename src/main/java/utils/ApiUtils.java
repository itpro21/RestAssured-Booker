package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {
    private static String token;

    public static void init() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    public static String getToken() {
        if (token == null) {
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body("{ \"username\" : \"admin\", \"password\" : \"password123\" }")
                    .when()
                    .post("/auth");

            token = response.jsonPath().getString("token");
        }
        return token;
    }
}