package mate.academy.spring.controllers;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.BookService;
import mate.academy.spring.service.RentService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String rentBook(@RequestParam("bookId") Long bookId) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        if (bookOptional.isEmpty()) {
            return "book/error";
        }
        Optional<User> userOptional = getCurrentUser();
        if (userOptional.isEmpty()) {
            return "user/error";
        }
        rentService.rentBook(userOptional.get(), bookOptional.get());
        return "forward:/book/all";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam ("bookId") Long bookId, ModelMap modelMap) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        if (bookOptional.isEmpty()) {
            return "book/error";
        }
        Optional<User> userOptional = getCurrentUser();
        if (userOptional.isEmpty()) {
            return "user/error";
        }
        rentService.returnBook(userOptional.get(), bookOptional.get());
        return getRentedBooks(modelMap);
    }

    @GetMapping("/rentedBooks")
    public String getRentedBooks(ModelMap modelMap) {
        Optional<User> userOptional = getCurrentUser();
        if (userOptional.isEmpty()) {
            return "user/error";
        }
        List<Book> booksRentByUser = rentService.getBooksRentByUser(userOptional.get());
        modelMap.put("books", booksRentByUser);
        return "rent/rentBook";
    }

    private Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByUserName(authentication.getName());
    }
}
