package katsai.nikolai.spring.service;

import java.util.List;

import katsai.nikolai.spring.entity.Author;

public interface AuthorService {
    Author add(Author author);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
