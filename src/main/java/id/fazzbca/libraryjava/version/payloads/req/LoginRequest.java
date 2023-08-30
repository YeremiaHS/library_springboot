package id.fazzbca.libraryjava.version.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @NotEmpty(message = "Username tidak boleh kosong")
    private String username;

    @NotEmpty(message = "mohon isikan password")
    @Size(min = 8, max = 12, message = "password harus berisi 8 - 12 karakter")
    private String password;
}
