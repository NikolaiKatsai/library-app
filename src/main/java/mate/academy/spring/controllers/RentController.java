package mate.academy.spring.controllers;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;
    @Autowired
    private UserService userService;

    @Autowired
    private RentService rentService;

    @Autowired
    private BookService bookService;

    @GetMapping("/getRent")
    public String rentBook(@RequestParam("bookId") Long bookId) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        User user = userService.getById(USER_ID);
        rentService.rentBook(user, bookOptional.get());
        return "forward:/book/allBooks";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam("bookId") Long bookId, ModelMap modelMap) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        User user = userService.getById(USER_ID);
        rentService.returnBook(user, bookOptional.get());
        return getBooksRentByUser(modelMap);
    }

    @GetMapping("/rentedBooks")
    public String getBooksRentByUser(ModelMap modelMap) {
        User user = userService.getById(USER_ID);
        List<Book> booksRentByUser = rentService.getBooksRentByUser(user);
        modelMap.put("books", booksRentByUser);
        return "rent/rentBook";
    }
}
