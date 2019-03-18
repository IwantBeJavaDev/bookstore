package pl.learn.bookstore.book.service;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.learn.bookstore.book.dao.Book;
import pl.learn.bookstore.book.dao.BookRepository;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class BookServiceImplTest {

    LocalDate date = LocalDate.of(2019,03,15);
    @TestConfiguration
    static class BookServiceImplTestContextConfiguration {

        @Bean
        public BookService bookService() {
            return new BookServiceImpl();
        }
    }

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;


    @Before
    public void setUp() {
        Mockito.when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> {
            Book book = new Book();
            book.setTitle("New book");
            book.setDescription("Common description");
            book.setIsbn("454545-4545");
            book.setReleaseDate(date);
            book.setIdBook(1L);
            return book;
        });
    }

    @Test
    public void whenDtoSave_thenIdNotNull() {
        BookDto bookDto = new BookDto();
        bookDto.setTitle("New book");
        bookDto.setDescription("Common description");
        bookDto.setIsbn("454545-4545");
        bookDto.setReleaseDate(date);

        bookDto = bookService.saveOrUpdate(bookDto);

        assertThat(bookDto.getTitle(), CoreMatchers.equalTo("New book"));
        assertThat(bookDto.getDescription(), CoreMatchers.equalTo("Common description"));
        assertThat(bookDto.getIsbn(), CoreMatchers.equalTo("454545-4545"));
        assertThat(bookDto.getReleaseDate(), CoreMatchers.equalTo(date));
        assertThat(bookDto.getIdBook(), notNullValue());
    }
}
