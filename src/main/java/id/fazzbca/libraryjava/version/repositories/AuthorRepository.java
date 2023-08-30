package id.fazzbca.libraryjava.version.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.fazzbca.libraryjava.version.models.Author;
import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, String> {
    //sql mencari author dari nama author
    List<Author> findByNameContaining(String name);

    Author findByName(String name);

    @Query(value = "select * from authors where name like %?%", nativeQuery = true)
    List<Author> getAuthorByName(String name);


}
