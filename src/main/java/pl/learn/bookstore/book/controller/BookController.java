package pl.learn.bookstore.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.learn.bookstore.book.service.BookDto;
import pl.learn.bookstore.book.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BookDto> bookDtos = bookService.findAll();
        model.addAttribute("books", bookDtos);
        return "/book/book-list";
    }

    @PostMapping("/add")
    public String saveBook(Model model) {


        return "/book/book-list";
    }
}
