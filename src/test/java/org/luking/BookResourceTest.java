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
                .body("genre", is("IT"));
    }

    @Test
    public void shouldGetSecondBook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 2).when()
                .get("/api/books/{id}").then()
                .statusCode(200)
                .body("title", is("segundo libro"))
                .body("author", is("Otro autor"))
                .body("yearOfPublication", is(2004))
                .body("genre", is("ficcion"));
    }

    @Test
    public void shouldGetThirdBook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 3).when()
                .get("/api/books/{id}").then()
                .statusCode(200)
                .body("title", is("tercer libro"))
                .body("author", is("George cloney"))
                .body("yearOfPublication", is(2015))
                .body("genre", is("Biografia"));
    }

    @Test
    public void shouldGetTalosBook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 4).when()
                .get("/api/books/{id}").then()
                .statusCode(200)
                .body("title", is("Talos de esparta"))
                .body("author", is("Valerio Massimo manfredi"))
                .body("yearOfPublication", is(2000))
                .body("genre", is("historia"));
    }

}
