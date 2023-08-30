package id.fazzbca.libraryjava.version.services.books;

import org.springframework.http.ResponseEntity;

import id.fazzbca.libraryjava.version.payloads.req.BookRequest;

public interface BookService {
    //create book
    ResponseEntity<?> addBookService(BookRequest request);

    //get all book by status deleted
    ResponseEntity<?> getBookService(Boolean isDeleted);

    //get book by id
    ResponseEntity<?> getBookById(String id);

    //update book by id
    ResponseEntity<?> updateBookByID(String id, BookRequest request);

    //delete book by id
    ResponseEntity<?> deleteBookService(String id);
}