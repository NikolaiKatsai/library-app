package katsai.nikolai.spring.dao;

import java.util.List;

import katsai.nikolai.spring.entity.Book;
import katsai.nikolai.spring.entity.Rent;
import katsai.nikolai.spring.entity.User;

public interface RentDao {
    Rent add(Rent rent);

    void returnBook(User user, Book book);

    List<Rent> getBooksRentByUser(User user);

    List<Book> getUserBooks(User user);
}
