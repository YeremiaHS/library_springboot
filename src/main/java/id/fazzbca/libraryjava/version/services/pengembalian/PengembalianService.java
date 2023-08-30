package id.fazzbca.libraryjava.version.services.pengembalian;

import org.springframework.http.ResponseEntity;

import id.fazzbca.libraryjava.version.payloads.req.PengembalianRequest;

public interface PengembalianService {
    ResponseEntity<?> createPengembalianService(PengembalianRequest request);
}
