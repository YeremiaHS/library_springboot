package id.fazzbca.libraryjava.version.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PeminjamanRequest {
    @NotEmpty(message = "username tidak boleh kosong")
    private String username;

    @NotEmpty(message = "masukkan buku yang ingin dipinjam")
    private String book;
}
