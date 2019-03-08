package pl.learn.bookstore.book.entity;

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
}
