package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.example.api.UnicornRequests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UnicornTest {
    @BeforeAll
    public static void setup() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/ed42d7fd71d74905806e8fd52a476ff4";
    }

    @Test
    public void userShouldBeAbleCreateUnicorn() {
        UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Tiny\",\n" +
                "  \"tailColor\": \"green\"\n" +
                "}");
    }

    @Test
    public void userShouldBeAbleDeleteExistingUnicorn() {
        // Step 1 Create unicorn
        String body = "\n" +
        "  \"name\": \"Nitty\",\n" +
                "  \"tailColor\": \"pink\"\n" +
                "}";
        String id = UnicornRequests.createUnicorn(body);

        // Step 2 Delete unicorn
        UnicornRequests.deleteUnicorn(id);

        //Step 3 Verify that unicorn doesn't exist any more
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void userShouldBeAbleUpdateExistingUnicorn() {
        // Step 1 Create unicorn
        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Nitty\",\n" +
                "  \"tailColor\": \"pink\"\n" +
                "}");

        // Step 2 Update unicorn
        String body = "{\n" +
                "  \"name\": \"Nitty\",\n" +
                "  \"tailColor\": \"violet\"\n" +
                "}";
        UnicornRequests.putUnicorn(id, body);

        //Step 3 Verify that unicorn tail updated
        String color = given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("tailColor");

        Assertions.assertEquals("violet", color);
    }
}
