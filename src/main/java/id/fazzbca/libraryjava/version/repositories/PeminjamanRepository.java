package id.fazzbca.libraryjava.version.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.fazzbca.libraryjava.version.models.Peminjaman;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, String>{
    Boolean existById(String id);

    // Peminjaman findById(String id);
}
