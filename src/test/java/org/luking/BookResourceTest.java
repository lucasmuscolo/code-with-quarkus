package org.luking;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shoudGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).when()
                .get("/api/books").then()
                .statusCode(200)
                .body("size()", is(4));
    }

    @Test
    public void shoudCountAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).when()
                .get("/api/books/count").then()
                .statusCode(200)
                .body(is("4"));
    }

    @Test
    public void shoudGetABook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1).when()
                .get("/api/books/{id}").then()
                .statusCode(200)
                .body("title", is("primer libro"))
                .body("author", is("Algun X"))
                .body("yearOfPublication", is(1999))
                .body("genre", is("erotico"));
    }
}
