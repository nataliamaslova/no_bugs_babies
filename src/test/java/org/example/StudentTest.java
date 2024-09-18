package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.example.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentTest {
    @BeforeAll
    public static void setup() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/4933172b3f0e4bfb873d95919fb93693";

        // Принцип программирования DRY: Do not Repeat Yourself
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        // given - when - then  BDD

        // сериализация из JSON в объект и наоборот
        Student student = Student.builder().name("Peter Lomin").grade(2).build();
        StudentRequests.createStudent(student);
        }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {
        /**
         * ПРИНЦИПЫ РАЗРАБОТКИ API ТЕСТОВ:
         * 1. Атомарность
         * 2. Тест сам себе готовит данные
         *
         * FAIL FIRST
         */

        // Step 1 Create student
        Student student = Student.builder().name("Peter Lomin").grade(2).build();
        Student createdStudent = StudentRequests.createStudent(student);

        // Step 2 Delete student
        StudentRequests.deleteStudent(createdStudent.getId());

        //Step 3 Verify that student doesn't exist any more
        given()
                .get("/student/" + createdStudent.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
