package id.fazzbca.libraryjava.version.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookRequest {
    @NotEmpty(message = "Title is required!")
    private String judul;

    @Size(max = 4, message = "Tahun terbit harus 4 karakter")
    private String tahunTerbit;

    @NotEmpty(message = "auhtor is required")
    private String namaPengarang;
    private String namaPenerbit;
}
