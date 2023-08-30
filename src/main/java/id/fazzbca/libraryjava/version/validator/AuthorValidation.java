package id.fazzbca.libraryjava.version.validator;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import id.fazzbca.libraryjava.version.models.Author;

@Component
public class AuthorValidation {
    public void validateAuthor(Author author){
        if (author == null || Objects.isNull(author)) {
            throw new NoSuchElementException("Author is not found!");
        }
    }
}
