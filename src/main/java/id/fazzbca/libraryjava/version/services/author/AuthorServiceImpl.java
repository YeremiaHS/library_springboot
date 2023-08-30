package id.fazzbca.libraryjava.version.services.author;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.fazzbca.libraryjava.version.models.Author;
import id.fazzbca.libraryjava.version.payloads.req.AuthorRequest;
import id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;
import id.fazzbca.libraryjava.version.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public ResponseEntity<?> addAuthorService(AuthorRequest request) {
        // cek request, ada yg null atau tidak
        // semisal null dari req akan throw exception
        if (request.getName() == null || request.getName() == " "){
            throw new IllegalArgumentException("Name is requiered!");
        }

        // membuat objek entitas dari objek request
        Author author = new Author(request.getName(), request.getSocialMedia());
        
        //save ke db
        authorRepository.save(author);

        //buatkan response
        return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Author successfully added", author);

    }

    @Override
    public ResponseEntity<?> getAuthorService() {
        //find all
        List<Author> authors = authorRepository.findAll();

        return ResponseHandler.responseData(200, "success", authors);
    }

    @Override
    public ResponseEntity<?> getAuthorByIdService(String id) {
        // cari id ada atau tidak
        // tidak ada id, maka akan di throw
        if (!authorRepository.existsById(id)) {
            throw new NoSuchElementException("ID is not found");
        }

        //find data author
        Author author = authorRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("ID is not found");
        } );

        return ResponseHandler.responseData(200, "Success", author);
    }

    @Override
    public ResponseEntity<?> updateAuthorById(String id, AuthorRequest request) {
        //find author
        Author author = authorRepository.findById(id).orElseThrow(() ->{
            throw new NoSuchElementException("ID is not found");
        });

        //ubah data author apakai setter
        if (request.getName() != "") {
            author.setName(request.getName());
        }

        if (request.getSocialMedia() != "") {
            author.setSocialMedia(request.getSocialMedia());
        }
        //save ke db
        authorRepository.save(author);

        //return response data 
        return ResponseHandler.responseData(200, "Success", author);
    }

    @Override
    public ResponseEntity<?> deleteAuthorById(String id) {
        //find id
        Author author = authorRepository.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("ID is not found");
        });

        //ubah field is deleted jadi true
        author.setDeleted(true);

        //save ke db
        authorRepository.save(author);

        //return response
        return ResponseHandler.responseData(200, "Success", null);
    }

    @Override
    public ResponseEntity<?> getAuthorByNameService(String name) {
        //find data
        List<Author> authors = authorRepository.findByNameContaining(name);

        return ResponseHandler.responseData(200, "success", authors);
    }
    
}
