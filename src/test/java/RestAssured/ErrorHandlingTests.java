package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class ErrorHandlingTests {

    public static final String BASE_URL = "https://api.tanamicapital.com";

    @Test
    public void testNotFound() {
        RestAssured.baseURI = BASE_URL;

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/nonexistentendpoint")
                .then()
                .statusCode(404);
    }
}