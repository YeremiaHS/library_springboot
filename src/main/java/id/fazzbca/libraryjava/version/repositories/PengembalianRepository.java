package id.fazzbca.libraryjava.version.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.fazzbca.libraryjava.version.models.Pengembalian;

public interface PengembalianRepository extends JpaRepository<Pengembalian, String> {
    
}
