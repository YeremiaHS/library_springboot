package id.fazzbca.libraryjava.version.services.user;

import org.springframework.http.ResponseEntity;

import id.fazzbca.libraryjava.version.payloads.req.LoginRequest;
import id.fazzbca.libraryjava.version.payloads.req.RegisterRequest;

public interface UserService {
    //register
    ResponseEntity<?> userReigisterService(RegisterRequest request);

    //login
    ResponseEntity<?> userLoginService(LoginRequest request);
}
