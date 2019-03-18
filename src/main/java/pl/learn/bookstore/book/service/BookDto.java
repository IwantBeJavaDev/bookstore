package pl.learn.bookstore.book.service;

import pl.learn.bookstore.common.AbstractDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class BookDto extends AbstractDto {
    public Long idBook;
    @NotNull
    public String title;
    public String description;
    @NotNull
    public LocalDate releaseDate;
    @NotNull
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
