package id.fazzbca.libraryjava.version.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.fazzbca.libraryjava.version.payloads.req.PeminjamanRequest;
import id.fazzbca.libraryjava.version.services.peminjaman.PeminjamanService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    @Autowired
    PeminjamanService peminjamanService;

    @PostMapping
    public ResponseEntity<?> createPeminjaman(@RequestBody @Valid PeminjamanRequest request) {
        return peminjamanService.createPeminjamanService(request);
    }
}
