package id.fazzbca.libraryjava.version.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import id.fazzbca.libraryjava.version.models.Books;

public interface BookRepository extends JpaRepository<Books, String> {
    List<Books> findByIsDeleted(Boolean isDeleted);

    Boolean existsByTitle(String judul);

    Books findByTitle(String judul);
}
