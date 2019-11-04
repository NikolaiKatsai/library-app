package katsai.nikolai.spring.dao;

import java.util.List;

import katsai.nikolai.spring.entity.Author;

public interface AuthorDao {
    Author add(Author author);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
