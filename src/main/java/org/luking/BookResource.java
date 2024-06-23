package org.luking;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject 
    BookRepository bookRepository;

    @Inject
    Logger LOG;

    @GET
    public List<Book> getAllBooks(){
        LOG.info("Get all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int getCountAllBooks(){
        LOG.info("Get all books count");
        return bookRepository.getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        LOG.info("Get all book id:"+id);
        return bookRepository.getBook(id);
    }

}
