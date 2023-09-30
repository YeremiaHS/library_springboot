package id.fazzbca.libraryjava.version.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Books {
    @Id
    @UuidGenerator
    private String id;

    @Column
    private String imgUrl;

    @Column(length = 100)
    private String title;

    @Column(length = 24)
    private String date;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(length = 255)
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatetdAt;

    private boolean isDeleted = false;
    
    public Books(String imgUrl, String title, String date, Author author, Publisher publisher, String content) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.date = date;
        this.author = author;
        this.publisher = publisher;
        this.content = content;

    }
}
