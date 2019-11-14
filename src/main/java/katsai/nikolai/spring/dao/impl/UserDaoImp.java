package katsai.nikolai.spring.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import katsai.nikolai.spring.dao.UserDao;
import katsai.nikolai.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getById(Long userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User u where u.username=:username", User.class);
        query.setParameter("username", username);
        return Optional.ofNullable(query.getSingleResult());
    }
}
