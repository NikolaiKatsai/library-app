package mate.academy.spring.controllers;

import java.util.Optional;

import mate.academy.spring.entity.Book;
import mate.academy.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getAllBooks(Model model) {
        model.addAttribute("allBooks", bookService.listBooks());
        return "book/allBooks";
    }

    @GetMapping("/{id}")
    public String bookInfo(@PathVariable("id") Long id, Model model) {
        Optional<Book> bookById = bookService.getBookById(id);
        Book book = bookById.get();
        model.addAttribute("book", book);
        return "book/bookInfo";
    }

    @GetMapping("/find")
    public String findByTitle(@RequestParam String title, Model model) {
        model.addAttribute("allBooks", bookService.findByTitle(title));
        return "book/allBooks";
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "book/createBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, Model model) {
        bookService.add(book);
        return getAllBooks(model);
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") Long id, Model model) {
        bookService.deleteBook(id);
        return getAllBooks(model);
    }
}
