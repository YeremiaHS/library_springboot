package id.fazzbca.libraryjava.version.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.fazzbca.libraryjava.version.models.Books;

public interface BookRepository extends JpaRepository<Books, String> {
    List<Books> findByIsDeleted(Boolean isDeleted);

    Boolean existsByTitle(String judul);

    Books findByTitle(String judul);

    @Query(value = "SELECT * FROM `books` WHERE is_deleted = 0", nativeQuery = true)
    List<Books> showBooks();
}
