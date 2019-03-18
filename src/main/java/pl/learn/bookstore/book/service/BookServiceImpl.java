package pl.learn.bookstore.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.learn.bookstore.book.dao.Book;
import pl.learn.bookstore.book.dao.BookRepository;
import pl.learn.bookstore.common.BaseAbstractService;

import java.util.List;

@Service
public class BookServiceImpl extends BaseAbstractService<BookDto,Book> implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public BookDto saveOrUpdate(BookDto dto) {
        Book book = createAndAssignEntityByDto(dto, Book.class);
        assignEntityToDto(bookRepository.save(book),dto);
        return dto;
    }

    @Override
    public void delete(BookDto dto) {

    }

    @Override
    public BookDto find(Long id) {
        return null;
    }
}
