package id.fazzbca.libraryjava.version.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PengembalianRequest {
    @NotEmpty(message = "masukan id peminjaman")
    private String peminjaman;
}
