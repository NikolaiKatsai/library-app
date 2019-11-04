package katsai.nikolai.spring.dao;

import java.util.List;
import java.util.Optional;

import katsai.nikolai.spring.entity.Book;

public interface BookDao {
    void add(Book book);

    List<Book> findBookByName(String name);

    List<Book> listBooks();

    Optional<Book> getBookById(Long id);

    void deleteBook(Long id);
}
