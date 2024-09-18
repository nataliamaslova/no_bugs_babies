package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UnicornTest {
    @BeforeAll
    public static void setup() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/dc9f774f028a437c8a2211b187731689";
    }

    @Test
    public void userShouldBeAbleCreateUnicorn() {
        Unicorn unicorn = Unicorn.builder().name("Tiny").tailColor("green").build();
        UnicornRequests.createUnicorn(unicorn);
    }

    @Test
    public void userShouldBeAbleReadUnicorn() {
        String id = "66ea9a9bfe837603e816c68a";
        Unicorn foundedUnicorn = UnicornRequests.readUnicornById(id);
        System.out.println(foundedUnicorn);
    }

    @Test
    public void userShouldBeAbleDeleteExistingUnicorn() {
        // Step 1 Create unicorn
        Unicorn unicorn = Unicorn.builder().name("Nitty").tailColor("pink").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        // Step 2 Delete unicorn
        UnicornRequests.deleteUnicorn(createdUnicorn.getId());

        // Step 3 Verify that unicorn doesn't exist any more
        given()
                .get("/unicorn/" + createdUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void userShouldBeAbleUpdateExistingUnicorn() {
        String expectedColor = "violet";
        // Step 1 Create unicorn
        Unicorn unicorn = Unicorn.builder().name("Nitty").tailColor("pink").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        // Step 2 Update unicorn
        UnicornRequests.updateUnicornTailColor(createdUnicorn, expectedColor);

        //Step 3 Verify that unicorn tailColor updated
        given()
                .get("/unicorn/" + createdUnicorn.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("tailColor", equalTo(expectedColor));
    }
}
