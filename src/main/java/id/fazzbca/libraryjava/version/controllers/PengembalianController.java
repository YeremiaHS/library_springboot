package id.fazzbca.libraryjava.version.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.fazzbca.libraryjava.version.payloads.req.PengembalianRequest;
import id.fazzbca.libraryjava.version.services.pengembalian.PengembalianService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pengembalian")
public class PengembalianController {
    @Autowired
    PengembalianService pengembalianService;

    @PostMapping
    public ResponseEntity<?> createPengembalian(@RequestBody @Valid PengembalianRequest request) {
        return pengembalianService.createPengembalianService(request);
    }
}
