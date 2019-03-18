package pl.learn.bookstore.book.dao;

import pl.learn.bookstore.common.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "BOOK", schema = "bookstore")
public class Book extends AbstractEntity {
    @Id
    @Column(name = "ID_BOOK")
    @SequenceGenerator(name = "S_BOOK",  allocationSize = 1, schema = "bookstore")
    @GeneratedValue(generator = "S_BOOK", strategy = GenerationType.SEQUENCE)
    private Long idBook;
    private String title;
    private String description;
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    private LocalDate releaseDate;

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
