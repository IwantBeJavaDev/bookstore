package pl.learn.bookstore.book.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOOK", schema = "bookstore")
public class Book {
    @Id
    @Column(name = "ID_BOOK")
    @SequenceGenerator(name = "S_BOOK", sequenceName = "S_BOOK", allocationSize = 1)
    @GeneratedValue(generator = "S_BOOK")
    private Long idBook;
    private String title;
    private String description;
    private Date releaseDate;

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
