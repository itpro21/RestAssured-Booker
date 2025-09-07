package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.ApiUtils;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class BookingSteps {
    private Response response;
    private static int bookingId;  // shared across scenarios

    public BookingSteps() {
        ApiUtils.init();
    }

    @Given("I create a booking with body")
    public void i_create_a_booking_with_body(String body) {
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when().post("/booking");
    }

    @Then("I store the booking id")
    public void i_store_the_booking_id() {
        bookingId = response.jsonPath().getInt("bookingid");
        assertTrue(bookingId > 0, "Booking ID should be greater than 0");
    }

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request(String endpoint) {
        response = given().when().get(resolveEndpoint(endpoint));
    }

    @Given("I send a POST request to {string} with body")
    public void i_send_a_post_request_with_body(String endpoint, String body) {
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when().post(resolveEndpoint(endpoint));
    }

    @Given("I send a PUT request to {string} with body")
    public void i_send_a_put_request_with_body(String endpoint, String body) {
        String token = ApiUtils.getToken();
        response = given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token=" + token)
                .body(body)
                .when().put(resolveEndpoint(endpoint));
    }

    @Given("I send a DELETE request to {string}")
    public void i_send_a_delete_request(String endpoint) {
        String token = ApiUtils.getToken();
        response = given()
                .header("Cookie", "token=" + token)
                .when().delete(resolveEndpoint(endpoint));
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expected) {
        assertTrue(response.asString().contains(expected));
    }

    // Helper to replace {bookingid} in endpoint
    private String resolveEndpoint(String endpoint) {
        if (endpoint.contains("{bookingid}")) {
            return endpoint.replace("{bookingid}", String.valueOf(bookingId));
        }
        return endpoint;
    }
}