package id.fazzbca.libraryjava.version.services.user;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.fazzbca.libraryjava.version.exceptions.custom.EntityFoundException;
import id.fazzbca.libraryjava.version.models.User;
import id.fazzbca.libraryjava.version.payloads.req.LoginRequest;
import id.fazzbca.libraryjava.version.payloads.req.RegisterRequest;
import id.fazzbca.libraryjava.version.payloads.res.ResponseHandler;
import id.fazzbca.libraryjava.version.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> userReigisterService(RegisterRequest request) {
        if (request.getUsername() == null || request.getUsername()=="") {
            throw new IllegalArgumentException("Username is requiered!");
        }

        if (request.getPassword() == null || request.getPassword()=="") {
            throw new IllegalArgumentException("Password is requiered!");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new EntityFoundException("Username sudah digunakan");
        }

        User user = new User(request.getUsername(), request.getPassword());

        userRepository.save(user);

        return ResponseHandler.responseMessage(201, "berhasil menambahkan user", true);
    }

    @Override
    public ResponseEntity<?> userLoginService(LoginRequest request) {
        if (!userRepository.existsByUsername(request.getUsername())) {
            throw new NoSuchElementException("username tak ditemukan");
        }

        User user = userRepository.findByUsername(request.getUsername());

        if (user.isDeleted()) {
            throw new NoSuchElementException("User tak ditemukan");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new NoSuchElementException("Password salah");
        }

        return ResponseHandler.responseMessage(200, "berhasil login", true);
    }
    
}
