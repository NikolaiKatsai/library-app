package katsai.nikolai.spring.service.impl;

import java.util.List;
import java.util.Optional;

import katsai.nikolai.spring.dao.BookDao;
import katsai.nikolai.spring.entity.Book;
import katsai.nikolai.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public Book add(Book book) {
        bookDao.add(book);
        return book;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findBookByName(title);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> getBookById(Long id) {
        return bookDao.getBookById(id);
    }

    @Transactional
    @Override
    public void deleteBook(Long id) {
        bookDao.deleteBook(id);
    }
}
