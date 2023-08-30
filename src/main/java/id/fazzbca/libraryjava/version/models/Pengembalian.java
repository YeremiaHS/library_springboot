package id.fazzbca.libraryjava.version.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pengembalian")
public class Pengembalian {
    @Id
    @UuidGenerator
    private String id;
    
    @OneToOne
    @JoinColumn(name = "peminjaman_id")
    private Peminjaman peminjaman;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    private Boolean isDeleted = false;

    public Pengembalian(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }
}
