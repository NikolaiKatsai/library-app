package mate.academy.spring.dao;

import java.util.List;

import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;

public interface RentDao {
    Rent add(Rent rent);

    void returnBook(User user, Book book);

    List<Rent> getBooksRentByUser(User user);

    List<Book> getUserBooks(User user);
}
