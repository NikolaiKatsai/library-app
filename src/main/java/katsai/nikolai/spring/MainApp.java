package katsai.nikolai.spring;

import java.sql.SQLException;

import java.util.List;

import katsai.nikolai.spring.config.AppConfig;
import katsai.nikolai.spring.entity.Author;
import katsai.nikolai.spring.entity.Book;
import katsai.nikolai.spring.entity.User;
import katsai.nikolai.spring.service.AuthorService;
import katsai.nikolai.spring.service.BookService;
import katsai.nikolai.spring.service.RentService;
import katsai.nikolai.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    private static UserService userService;
    private static AuthorService authorService;
    private static RentService rentService;
    private static BookService bookService;

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        userService = context.getBean(UserService.class);
        authorService = context.getBean(AuthorService.class);
        rentService = context.getBean(RentService.class);
        bookService = context.getBean(BookService.class);

        // Add Users
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        bookService.add(new Book("a", 2000, 100));
        List<Book> books = bookService.findByTitle("a");
        System.out.println(books.get(0));

        authorService.add((new Author("Bob", "Macron")).addBook(books.get(0)));
        List<Author> authors = authorService.findByName("Bob");

        rentService.rentBook(users.get(0), books.get(0));
        books = bookService.findByTitle("a");
        books = authors.get(0).getBooks();
        System.out.println(books);
        context.close();
    }
}
