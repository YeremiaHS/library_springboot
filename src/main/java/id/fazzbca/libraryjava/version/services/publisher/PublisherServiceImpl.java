package id.fazzbca.libraryjava.version.services.publisher;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.fazzbca.libraryjava.version.models.Publisher;
import id.fazzbca.libraryjava.version.payloads.req.PublisherRequest;
import id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;
import id.fazzbca.libraryjava.version.repositories.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public ResponseEntity<?> addPublisherService(PublisherRequest request) {
        //cek req
        //exception for null
        if (request.getName() == null || request.getName() == "") {
            throw new IllegalArgumentException("Name is empty");
        }

        //onjek entitas dari request
        Publisher publisher = new Publisher(request.getName(), request.getAddress());

        //save db
        publisherRepository.save(publisher);

        //response
        return ResponseHandler.responseData(HttpStatus.CREATED.value(), "author successfully added", publisher);
    }

    @Override
    public ResponseEntity<?> getPublisherService() {
        //find all
        List<Publisher> publishers = publisherRepository.findAll();

        return ResponseHandler.responseData(200, "success", publishers);
    }

    @Override
    public ResponseEntity<?> getPublisherByIdService(String id) {
        //cari id
        //throw error
        if (!publisherRepository.existsById(id)) {
            throw new NoSuchElementException("ID is not found");
        }

        //find data publisher
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("ID is not found");
        });

        return ResponseHandler.responseData(200, "success", publisher);
    }

    @Override
    public ResponseEntity<?> getPublisherByNameService(String name) {
        //find data
        List<Publisher> publishers = publisherRepository.findByNameContaining(name);

        return ResponseHandler.responseData(200, "success", publishers);
    }

    @Override
    public ResponseEntity<?> updatePublisherByIdService(String id, PublisherRequest request) {
        //find publisher
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("ID is not found");
        });

        //ubah data publisher
        if (request.getName() != "") {
            publisher.setName(request.getName());
        }

        if (request.getAddress() != "") {
            publisher.setAddress(request.getAddress());
        }

        //save db
        publisherRepository.save(publisher);

        //return
        return ResponseHandler.responseData(200, "success", publisher);
    }

    @Override
    public ResponseEntity<?> deletePublisherByIdService(String id) {
        //find id
        Publisher publisher = publisherRepository.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("ID is not found");
        });

        //ubah filed delete status
        publisher.setDeleted(true);

        //save db
        publisherRepository.save(publisher);

        //return response
        return ResponseHandler.responseData(200, "success", publisher);
    }

    @Override
    public ResponseEntity<?> getPublisherByNotDeleted(String name) {
        //find data
        List<Publisher> publishers = publisherRepository.getPublisherNotDeleted(name);

        return ResponseHandler.responseData(200, "success", publishers);
    }
    
}
