package mate.academy.spring.service;

import java.util.List;

import mate.academy.spring.entity.Author;

public interface AuthorService {
    Author add(Author author);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
