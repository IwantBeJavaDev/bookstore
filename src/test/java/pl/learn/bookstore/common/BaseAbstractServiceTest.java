package pl.learn.bookstore.common;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.learn.bookstore.book.dao.Book;
import pl.learn.bookstore.book.service.BookDto;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
public class BaseAbstractServiceTest {

    private BaseAbstractService baseAbstractService;

    @Before
    public void setUp() {
        baseAbstractService = new BaseAbstractService() {}  ;
    }

    @Test
    public void whenDtoMapper_thenEntityResult() {
        //given
        BookDto bookDto = new BookDto();
        bookDto.description = "description";
        bookDto.releaseDate = LocalDate.of(2019, 03, 12);
        bookDto.title = "title";
        bookDto.isbn = "isbn";
        Book book = new Book();
        //Then
        baseAbstractService.assignDtoToEntity(bookDto, book);

        assertThat(book.getDescription(), equalTo(bookDto.description));
        assertThat(book.getIdBook(), equalTo(bookDto.idBook));
        assertThat(book.getTitle(), equalTo(bookDto.title));
        assertThat(book.getReleaseDate(), equalTo(bookDto.releaseDate));
        assertThat(book.getIsbn(), equalTo(bookDto.isbn));
    }
}
