package mate.academy.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(user, book);
        return rentDao.add(rent);
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        rentDao.returnBook(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        List<Book> books = new ArrayList<>();
        List<Rent> rentByUser = rentDao.getBooksRentByUser(user);
        for (Rent rent : rentByUser) {
            books.add(rent.getBook());
        }
        return books;
    }
}
