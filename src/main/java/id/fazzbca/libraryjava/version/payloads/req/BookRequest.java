package id.fazzbca.libraryjava.version.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BookRequest {
    @NotEmpty(message = "Image is required!")
    private String imgUrl;

    @NotEmpty(message = "Title is required!")
    private String judul;

    @Size(max = 24, message = "Tahun maks 24 karakter")
    private String tanggalTerbit;

    @NotEmpty(message = "auhtor is required")
    private String namaPengarang;
    private String namaPenerbit;

    @NotEmpty(message = "content is required!")
    private String konten;
}
