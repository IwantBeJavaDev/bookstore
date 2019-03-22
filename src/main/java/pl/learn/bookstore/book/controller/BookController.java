package pl.learn.bookstore.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.learn.bookstore.book.service.BookDto;
import pl.learn.bookstore.book.service.BookService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(LocalDate.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BookDto> bookDtos = bookService.findAll();
        model.addAttribute("books", bookDtos);
        return "/book/book-list";
    }


    @GetMapping("/showFormToAdd")
    public String showFormToAdd(Model bookModel) {
        BookDto bookDto = new BookDto();
        bookModel.addAttribute("bookDto", bookDto);
        return "/book/show-book-form";
    }

    @PostMapping("/add")
    public String saveBook( @ModelAttribute @Valid BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/book/show-book-form";
        }
        bookService.saveOrUpdate(bookDto);
        return "redirect:/book/list";
    }
}
