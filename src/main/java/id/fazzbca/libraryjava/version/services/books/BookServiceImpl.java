package id.fazzbca.libraryjava.version.services.books;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.fazzbca.libraryjava.version.models.Author;
import id.fazzbca.libraryjava.version.models.Books;
import id.fazzbca.libraryjava.version.models.Publisher;
import id.fazzbca.libraryjava.version.payloads.req.BookRequest;
import id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;
import id.fazzbca.libraryjava.version.repositories.AuthorRepository;
import id.fazzbca.libraryjava.version.repositories.BookRepository;
import id.fazzbca.libraryjava.version.repositories.PublisherRepository;
import id.fazzbca.libraryjava.version.validator.AuthorValidation;
import id.fazzbca.libraryjava.version.validator.PublisherValidation;

@Service
public class BookServiceImpl implements BookService {

@Autowired
BookRepository bookRepository;

@Autowired
AuthorRepository authorRepository;

@Autowired
PublisherRepository publisherRepository;

@Autowired
PublisherValidation publisherValidation;

@Autowired
AuthorValidation authorValidation;

    @Override
    public ResponseEntity<?> addBookService(BookRequest request) {
        //cek input
        //cari data author dan penerbit
        //request author dengan id
        Author author = authorRepository.findByName(request.getNamaPengarang());

        //validasi author
        authorValidation.validateAuthor(author);

        //request publisher dengan id
        Publisher publisher = publisherRepository.findByName(request.getNamaPenerbit());

        //validasi publisher
        publisherValidation.validatePublisher(publisher);

        //objek entitias dari book
        Books book = new Books(request.getJudul(), request.getTahunTerbit(), author, publisher);

        //save ke db
        bookRepository.save(book);

        //return response
        return ResponseHandler.responseMessage(201, "Book successfully addedd", true);

    }

    @Override
    public ResponseEntity<?> getBookService(Boolean isDeleted) {
        List<Books> books = new ArrayList<>();

        //cek isDeleted null atau tidak
        if (isDeleted == null) {
            books = bookRepository.findAll();
        } else{
            books = bookRepository.findByIsDeleted(isDeleted);
        }

        //return response
        return ResponseHandler.responseData(200, "success", books);
    }

    @Override
    public ResponseEntity<?> getBookById(String id) {
        Books books = bookRepository.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("ID book is not found");
        });

        return ResponseHandler.responseData(200, "success", books);
    }

    @Override
    public ResponseEntity<?> updateBookByID(String id, BookRequest request) {
        Books book = bookRepository.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("Book not found");
        });

        if (request.getJudul() != "") {
            book.setTitle(request.getJudul());
        }

        if (request.getTahunTerbit() != "") {
            book.setYear(request.getTahunTerbit());
        }

        if (request.getNamaPengarang() != "") {
            Author author = authorRepository.findByName(request.getNamaPengarang());
            authorValidation.validateAuthor(author);
            book.setAuthor(author);
        }

        if (request.getNamaPenerbit() != "") {
            Publisher publisher = publisherRepository.findByName(request.getNamaPenerbit());
            publisherValidation.validatePublisher(publisher);
            book.setPublisher(publisher);
        }
        

        //save ke db
        bookRepository.save(book);

        return ResponseHandler.responseMessage(200, "Book successfully updated", true);
    }

    @Override
    public ResponseEntity<?> deleteBookService(String id) {
        Books book = bookRepository.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("id book not found");
        });

        book.setDeleted(true);
        bookRepository.save(book);

        return ResponseHandler.responseMessage(200, "Success delete", true);
    }
    
}
