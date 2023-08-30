package id.fazzbca.libraryjava.version.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.fazzbca.libraryjava.version.payloads.req.AuthorRequest;
//import id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;
import id.fazzbca.libraryjava.version.services.author.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody AuthorRequest request) {
        //try {
            return authorService.addAuthorService(request);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping
    public ResponseEntity<?> getAuthors(){
        //try {
            return authorService.getAuthorService();
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable String id) {
        //try {
            return authorService.getAuthorByIdService(id);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getAuthorByName(@PathVariable String name) {
        //try {
            return authorService.getAuthorByNameService(name);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthorById(@PathVariable String id, @RequestBody AuthorRequest request) {
        //try {
            return authorService.updateAuthorById(id, request);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable String id) {
        //try {
            return authorService.deleteAuthorById(id);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    
}
