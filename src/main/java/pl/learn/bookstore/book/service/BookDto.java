package pl.learn.bookstore.book.service;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class BookDto implements Serializable {
    private Long idBook;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private Date releaseDate;
}
