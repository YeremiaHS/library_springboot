package id.fazzbca.libraryjava.version.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.fazzbca.libraryjava.version.models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, String>{
    List<Publisher> findByNameContaining(String name);

    Publisher findByName(String name);

    @Query(value = "select * from publishers where name like %?% and is_deleted = 'false'", nativeQuery = true)
    List<Publisher> getPublisherNotDeleted(String name);
}
