package pl.learn.bookstore.book.service;

import pl.learn.bookstore.book.dao.Book;
import pl.learn.bookstore.common.BaseService;

import java.util.List;

public interface BookService extends BaseService<BookDto> {
    List<BookDto> findAll();
}
