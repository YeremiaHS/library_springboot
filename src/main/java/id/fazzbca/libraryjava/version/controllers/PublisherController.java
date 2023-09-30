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

import id.fazzbca.libraryjava.version.payloads.req.PublisherRequest;
//simport id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;
import id.fazzbca.libraryjava.version.services.publisher.PublisherService;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    PublisherService publisherService;

    @PostMapping("/add")
    public ResponseEntity<?> createPublisher(@RequestBody PublisherRequest request) {
        //try {
            return publisherService.addPublisherService(request);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping
    public ResponseEntity<?> getPublisher(){
        //try {
            return publisherService.getPublisherService();
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPublisherById(@PathVariable String id){
        //try {
            return publisherService.getPublisherByIdService(id);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePublisherById(@PathVariable String id, @RequestBody PublisherRequest request){
        //try {
            return publisherService.updatePublisherByIdService(id, request);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getPublisherByName(@PathVariable String name) {
        //try {
            return publisherService.getPublisherByNameService(name);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisherById(@PathVariable String id) {
        //try {
            return publisherService.deletePublisherByIdService(id);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }

    @GetMapping("/not_deleted/{name}") 
    public ResponseEntity<?> getPublisherByNotDeleted(@PathVariable String name){
        //try {
            return publisherService.getPublisherByNotDeleted(name);
        // } catch (Exception e) {
        //     return ResponseHandler.responseError(500, e.getMessage(), null);
        // }
    }
}
