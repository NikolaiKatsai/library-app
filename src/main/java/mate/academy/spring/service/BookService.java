package mate.academy.spring.service;

import java.util.List;

import mate.academy.spring.entity.Book;

public interface BookService {
    Book add(Book book);

    List<Book> listBooks();

    List<Book> findByTitle(String title);
}
