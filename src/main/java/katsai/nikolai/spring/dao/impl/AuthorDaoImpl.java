package katsai.nikolai.spring.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import katsai.nikolai.spring.dao.AuthorDao;
import katsai.nikolai.spring.entity.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Author add(Author author) {
        sessionFactory.getCurrentSession().save(author);
        return author;
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("from Author a where a.name like concat('%', :name, '%')",
                        Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession()
                .createQuery("from Author a where a.name like concat('%', :name, '%')"
                                + " and a.surname like concat('%', :surname, '%')",
                        Author.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList();
    }
}
