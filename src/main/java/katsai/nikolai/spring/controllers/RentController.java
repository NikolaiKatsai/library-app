package katsai.nikolai.spring.controllers;

import java.util.List;
import java.util.Optional;

import java.security.Principal;
import katsai.nikolai.spring.entity.Book;
import katsai.nikolai.spring.entity.User;
import katsai.nikolai.spring.service.BookService;
import katsai.nikolai.spring.service.RentService;
import katsai.nikolai.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rent")
public class RentController {
    @Autowired
    private UserService userService;

    @Autowired
    private RentService rentService;

    @Autowired
    private BookService bookService;

    @GetMapping("/getRent")
    @ResponseBody
    public String rentBook(@RequestParam("bookId") Long bookId, Principal principal) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        Optional<User> user = userService.findByUsername(principal.getName());
        rentService.rentBook(user.get(), bookOptional.get());
        return "forward:/book/allBooks";
    }

    @GetMapping("/return")
    @ResponseBody
    public String returnBook(@RequestParam("bookId") Long bookId, ModelMap modelMap,
                             Principal principal) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        Optional<User> user = userService.findByUsername(principal.getName());
        rentService.returnBook(user.get(), bookOptional.get());
        return getBooksRentByUser(modelMap, principal);
    }

    @GetMapping("/rentedBooks")
    @ResponseBody
    public String getBooksRentByUser(ModelMap modelMap, Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());
        List<Book> booksRentByUser = rentService.getBooksRentByUser(user.get());
        modelMap.put("books", booksRentByUser);
        return "rent/rentBook";
    }
}

