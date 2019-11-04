package katsai.nikolai.spring.service.impl;

import java.util.List;

import katsai.nikolai.spring.dao.AuthorDao;
import katsai.nikolai.spring.entity.Author;
import katsai.nikolai.spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByName(String name) {
        return authorDao.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        return authorDao.findByNameAndSurname(name, surname);
    }
}
