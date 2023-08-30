package id.fazzbca.libraryjava.version.services.publisher;

import org.springframework.http.ResponseEntity;

import id.fazzbca.libraryjava.version.payloads.req.PublisherRequest;

public interface PublisherService {
    //crud publisher
    //create, read all, read by id, read by nama penerbit, read by deleted

    //create
    ResponseEntity<?> addPublisherService(PublisherRequest request);

    //read all
    ResponseEntity<?> getPublisherService();

    //read by id
    ResponseEntity<?> getPublisherByIdService(String id);

    //read by nama penerbit
    ResponseEntity<?> getPublisherByNameService(String name);

    //read by deleted
    ResponseEntity<?> getPublisherByNotDeleted(String name);

    //update
    ResponseEntity<?> updatePublisherByIdService(String id, PublisherRequest request);

    //delete
    ResponseEntity<?> deletePublisherByIdService(String id);
}
