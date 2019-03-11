package pl.learn.bookstore.book.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.learn.bookstore.BookstoreApplication;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookstoreApplication.class)
@ActiveProfiles("postgres-test")
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    public void whenNewBookAdd_thenIdNotNull() {
        //given
        Book book = new Book();
        book.setTitle("Scooby doo");
        book.setReleaseDate(LocalDate.now());
        book.setIsbn("22333-klld-9993");
        bookRepository.save(book);
        assertThat(book.getIdBook(), notNullValue());


    }
}
