package pl.learn.bookstore.book.service;

import org.springframework.format.annotation.DateTimeFormat;
import pl.learn.bookstore.common.AbstractDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class BookDto extends AbstractDto {
    public Long idBook;
    @NotNull(message = "Title is required")
    public String title;
    public String description;
    @PastOrPresent(message = "Release date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public LocalDate releaseDate;
    @NotNull(message = "ISBN is required")
    public String isbn;

    public BookDto() {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
