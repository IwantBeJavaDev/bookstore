package pl.learn.bookstore.book.dao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.transaction.annotation.Transactional;
import pl.learn.bookstore.BookstoreApplication;
import pl.learn.bookstore.common.TestUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookstoreApplication.class)
@ActiveProfiles("dev")
@Transactional
public class BookRepositoryTest {
    Logger log = LoggerFactory.getLogger(BookRepositoryTest.class);
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
//        log.warn(String.valueOf(book.getIdBook()));
        assertThat(book.getIdBook(), notNullValue());

    }

    @After
    public void cleanDataBase() {
        TestUtil.clearAllTables(entityManager);
    }

}
