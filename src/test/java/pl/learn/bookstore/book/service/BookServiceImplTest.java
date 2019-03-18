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
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        Mockito.when(bookRepository.findAll()).thenAnswer(invocation -> {
            List<Book> bookEntityList = new ArrayList<>();
            Book book1 = new Book();
            book1.setIdBook(1L);
            book1.setTitle("Title1");
            book1.setIsbn("isbn_1-ddkk");
            book1.setDescription("Description");
            book1.setReleaseDate(date);

            Book book2 = new Book();
            book2.setIdBook(2L);
            book2.setTitle("Title1");
            book2.setIsbn("isbn_2-ddkk");
            book2.setDescription("Description");
            book2.setReleaseDate(date);

            bookEntityList.add(book1);
            bookEntityList.add(book2);

            return bookEntityList;
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

    @Test
    public void whenFind_thenListBookDtoReturn() {
        //when
        List<BookDto> bookDtos = bookService.findAll();
        //then
        assertThat(bookDtos, containsInAnyOrder(bookDtos.get(0),bookDtos.get(1)));
    }
}
