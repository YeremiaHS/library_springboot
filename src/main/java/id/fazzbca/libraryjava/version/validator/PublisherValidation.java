package id.fazzbca.libraryjava.version.validator;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import id.fazzbca.libraryjava.version.models.Publisher;

@Component
public class PublisherValidation {
    public void validatePublisher(Publisher publisher) {
        if (publisher == null || Objects.isNull(publisher) ) {
            throw new NoSuchElementException("publisher not found");
        }
    }
}
