package id.fazzbca.libraryjava.version.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.fazzbca.libraryjava.version.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    Boolean existsByUsername(String username);
    
    User findByUsername(String username);

    User findByPassword(String password);
}
