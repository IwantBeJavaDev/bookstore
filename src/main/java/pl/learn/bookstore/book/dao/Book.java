package pl.learn.bookstore.book.dao;

import pl.learn.bookstore.common.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Table(name = "BOOK", schema = "bookstore")
public class Book extends AbstractEntity {
    @Id
    @Column(name = "ID_BOOK")
    @SequenceGenerator(name = "S_BOOK", allocationSize = 1, schema = "bookstore")
    @GeneratedValue(generator = "S_BOOK", strategy = GenerationType.SEQUENCE)
    private Long idBook;
    @NotBlank(message = "Title id required")
    private String title;
    private String description;
    @NotBlank(message = "ISBN is required")
    private String isbn;
    @PastOrPresent(message = "Release date is required")
    private LocalDate releaseDate;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Book() {
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
