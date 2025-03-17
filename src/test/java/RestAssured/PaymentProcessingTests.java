package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PaymentProcessingTests {

    private static final String BASE_URL = "https://api.tanamicapital.com";
    @Test
    public void testValidPayment() {
        RestAssured.baseURI = BASE_URL;

        given()
                .contentType(ContentType.JSON)
                .body("{\"amount\": 100.00, \"currency\": \"BHD\", \"recipient\": \"recipient@example.com\", \"description\": \"Test payment\"}")
                .when()
                .post("/payments")
                .then()
                .statusCode(201)
                .body("transactionId", notNullValue())
                .body("status", equalTo("processed"));
    }

    @Test
    public void testInvalidAmount() {
        RestAssured.baseURI = BASE_URL;

        given()
                .contentType(ContentType.JSON)
                .body("{\"amount\": -100.00, \"currency\": \"BHD\", \"recipient\": \"recipient@example.com\", \"description\": \"Test payment\"}")
                .when()
                .post("/payments")
                .then()
                .statusCode(400)
                .body("error", equalTo("Invalid amount"));
    }

    @Test
    public void testMissingRequiredField() {
        RestAssured.baseURI = BASE_URL;

        given()
                .contentType(ContentType.JSON)
                .body("{\"amount\": 100.00, \"RestAPI\": \"RestAPI@example.com\", \"description\": \"Test payment\"}")
                .when()
                .post("/payments")
                .then()
                .statusCode(400)
                .body("error", equalTo("Missing required field: currency"));
    }

    @Test
    public void testInvalidCurrency() {
        RestAssured.baseURI = BASE_URL;

        given()
                .contentType(ContentType.JSON)
                .body("{\"amount\": 100.00, \"currency\": \"ZZZ\", \"recipient\": \"recipient@example.com\", \"description\": \"Test payment\"}")
                .when()
                .post("/payments")
                .then()
                .statusCode(400)
                .body("error", equalTo("Invalid currency"));
    }
}