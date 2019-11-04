package katsai.nikolai.spring.service;

import java.util.List;

import katsai.nikolai.spring.entity.Book;
import katsai.nikolai.spring.entity.Rent;
import katsai.nikolai.spring.entity.User;

public interface RentService {
    Rent rentBook(User user, Book book);

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
