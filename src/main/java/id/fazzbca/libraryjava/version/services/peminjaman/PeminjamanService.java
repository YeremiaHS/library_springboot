package id.fazzbca.libraryjava.version.services.peminjaman;

import org.springframework.http.ResponseEntity;

import id.fazzbca.libraryjava.version.payloads.req.PeminjamanRequest;

public interface PeminjamanService {
    ResponseEntity<?> createPeminjamanService(PeminjamanRequest request);
}
