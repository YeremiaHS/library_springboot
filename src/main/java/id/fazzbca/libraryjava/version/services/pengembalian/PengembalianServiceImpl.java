package id.fazzbca.libraryjava.version.services.pengembalian;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.fazzbca.libraryjava.version.models.Books;
import id.fazzbca.libraryjava.version.models.Peminjaman;
import id.fazzbca.libraryjava.version.models.Pengembalian;
import id.fazzbca.libraryjava.version.payloads.req.PengembalianRequest;
import id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;
import id.fazzbca.libraryjava.version.repositories.BookRepository;
import id.fazzbca.libraryjava.version.repositories.PeminjamanRepository;
import id.fazzbca.libraryjava.version.repositories.PengembalianRepository;

@Service
public class PengembalianServiceImpl implements PengembalianService{
    @Autowired
    PengembalianRepository pengembalianRepository;

    @Autowired
    PeminjamanRepository peminjamanRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public ResponseEntity<?> createPengembalianService(PengembalianRequest request) {
        if (request.getPeminjaman() == null || request.getPeminjaman() == "") {
            throw new IllegalArgumentException("Masukkan id peminjaman");
        }
        if (!peminjamanRepository.existsById(request.getPeminjaman())) {
            throw new NoSuchElementException("peminjaman tak ditemukan");
        }

        Peminjaman peminjaman = peminjamanRepository.findById(request.getPeminjaman()).orElseThrow(()-> {
            throw new NoSuchElementException("Peminjaman tak ditemukan");
        });

        if (peminjaman.getIsDeleted()) {
            throw new NoSuchElementException("Peminjaman tak ditemukan");
        }

        peminjaman.setIsDeleted(true);

        Books book = peminjaman.getBook();

        book.setDeleted(false);

        Pengembalian pengembalian = new Pengembalian(peminjaman);

        pengembalianRepository.save(pengembalian);

        return ResponseHandler.responseMessage(201, "berhasil melakukan pengembalian", true);
    }
}
