Feature: Booking API tests

  Scenario: Create a new booking
    Given I create a booking with body
      """
      {
        "firstname": "John",
        "lastname": "Doe",
        "totalprice": 150,
        "depositpaid": true,
        "bookingdates": {
          "checkin": "2024-01-01",
          "checkout": "2024-01-10"
        },
        "additionalneeds": "Breakfast"
      }
      """
    Then the response status code should be 200
    And I store the booking id

  Scenario: Get the created booking
    Given I send a GET request to "/booking/{bookingid}"
    Then the response status code should be 200
    And the response should contain "John"

  Scenario: Update the created booking
    Given I send a PUT request to "/booking/{bookingid}" with body
      """
      {
        "firstname": "Jane",
        "lastname": "Smith",
        "totalprice": 200,
        "depositpaid": false,
        "bookingdates": {
          "checkin": "2024-02-01",
          "checkout": "2024-02-05"
        },
        "additionalneeds": "Dinner"
      }
      """
    Then the response status code should be 200
    And the response should contain "Jane"

  Scenario: Delete the created booking
    Given I send a DELETE request to "/booking/{bookingid}"
    Then the response status code should be 201