package katsai.nikolai.spring.service.impl;

import java.util.List;

import katsai.nikolai.spring.dao.RentDao;
import katsai.nikolai.spring.entity.Book;
import katsai.nikolai.spring.entity.Rent;
import katsai.nikolai.spring.entity.User;
import katsai.nikolai.spring.service.RentService;
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
        return rentDao.getUserBooks(user);
    }
}
