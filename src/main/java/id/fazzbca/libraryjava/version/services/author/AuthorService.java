package id.fazzbca.libraryjava.version.services.author;

import org.springframework.http.ResponseEntity;

import id.fazzbca.libraryjava.version.payloads.req.AuthorRequest;

public interface AuthorService {
    //kerangka
    //create
    ResponseEntity<?> addAuthorService(AuthorRequest request);


    //find all authors
    ResponseEntity<?> getAuthorService();

    //find by id
    ResponseEntity<?> getAuthorByIdService(String id);

    //update
    ResponseEntity<?> updateAuthorById(String id, AuthorRequest request);

    //delete
    ResponseEntity<?> deleteAuthorById(String id);

    //find by name
    ResponseEntity<?> getAuthorByNameService(String name);
}
