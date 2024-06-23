package org.luking;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "sci-fi")
    String genre;
 
    public List<Book> getAllBooks(){
        return List.of(
            new Book(1,"primer libro","Algun X",1999,genre),
            new Book(2,"segundo libro","Otro autor",2004,"ficcion"),
            new Book(3,"tercer libro","George cloney",2015,"Biografia"),
            new Book(4,"Talos de esparta","Valerio Massimo manfredi",2000,"historia")
        );
    }

    public Optional<Book> getBook(int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }

}
