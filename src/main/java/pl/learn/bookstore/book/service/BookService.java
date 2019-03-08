package pl.learn.bookstore.book.service;

import pl.learn.bookstore.book.dao.Book;

import java.util.List;

public interface BookService {
    Book saveOrUpdate(BookDto bookDto);

    void delete(Long idBook);

    List<Book> findAll();
}
