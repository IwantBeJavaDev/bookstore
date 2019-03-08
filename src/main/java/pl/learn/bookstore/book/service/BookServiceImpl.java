package pl.learn.bookstore.book.service;

import org.springframework.stereotype.Service;
import pl.learn.bookstore.book.dao.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Book saveOrUpdate(BookDto bookDto) {
        return null;
    }

    @Override
    public void delete(Long idBook) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
