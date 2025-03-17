package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.util.concurrent.TimeUnit;

public class TimeoutTests {

    private static final String BASE_URL = "https://api.tanamicapital.com";

    @Test
    public void testTimeout() {
        RestAssured.baseURI = BASE_URL;

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/payments")
                .then()
                .statusCode(500);
    }
}