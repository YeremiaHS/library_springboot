package id.fazzbca.libraryjava.version.services.peminjaman;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.fazzbca.libraryjava.version.models.Books;
import id.fazzbca.libraryjava.version.models.Peminjaman;
import id.fazzbca.libraryjava.version.models.User;
import id.fazzbca.libraryjava.version.payloads.req.PeminjamanRequest;
import id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;
import id.fazzbca.libraryjava.version.repositories.BookRepository;
import id.fazzbca.libraryjava.version.repositories.PeminjamanRepository;
import id.fazzbca.libraryjava.version.repositories.UserRepository;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    PeminjamanRepository peminjamanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;


    @Override
    public ResponseEntity<?> createPeminjamanService(PeminjamanRequest request) {
        if (request.getBook() == null || request.getBook() == "") {
            throw new IllegalArgumentException("Masukkan buku");
        }

        if (request.getUsername() == null || request.getUsername() =="") {
            throw new IllegalArgumentException("masukkan peminjam");
        }

        if (!userRepository.existsByUsername(request.getUsername())) {
            throw new NoSuchElementException("username tak ditemukan");
        }

        User user = userRepository.findByUsername(request.getUsername());

        if (user.isDeleted()) {
            throw new NoSuchElementException("User tak ditemukan");
        }

        if (!bookRepository.existsByTitle(request.getBook())) {
            throw new NoSuchElementException("Buku tak ditemukan");
        }

        Books book = bookRepository.findByTitle(request.getBook());

        if (book.isDeleted()) {
            throw new NoSuchElementException("Buku tak ditemukan");
        }

        book.setDeleted(true);

        Peminjaman peminjaman = new Peminjaman(user, book);

        peminjamanRepository.save(peminjaman);

        return ResponseHandler.responseMessage(201, "berhasil melakukan peminjaman", true);
    }
    
}
