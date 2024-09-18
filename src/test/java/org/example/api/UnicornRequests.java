package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.example.api.models.Unicorn;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static Unicorn createUnicorn(Unicorn unicorn) {
        String unicornJson = unicornToJson(unicorn);
        return given()
                .body(unicornJson)
                .contentType(ContentType.JSON)
                .when()
                .post("/unicorn")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract()
                .as(Unicorn.class, ObjectMapperType.GSON);
    }

    public static Unicorn readUnicornById(String id) {
        return given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Unicorn.class, ObjectMapperType.GSON);
    }

    public static void deleteUnicorn(String id) {
        given()
                .delete("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public static void updateUnicornTailColor(Unicorn unicorn, String tailColor) {
        unicorn.setTailColor(tailColor);
        String unicornJson = unicornToJson(unicorn);

        given()
                .body(unicornJson)
                .contentType(ContentType.JSON)
                .when()
                .put("/unicorn/" + unicorn.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    private static String unicornToJson(Unicorn unicorn) {
        ObjectMapper objectMapper = new ObjectMapper();
        String unicornJson = null;
        try {
            unicornJson = objectMapper.writeValueAsString(unicorn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return unicornJson;
    }
}
