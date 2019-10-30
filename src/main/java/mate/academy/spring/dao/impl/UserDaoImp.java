package mate.academy.spring.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import mate.academy.spring.dao.UserDao;
import mate.academy.spring.entity.User;
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
    public Optional<User> getUserByUserName(String userName) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("from User where userName=:userName",
                        User.class);
        query.setParameter("userName", userName);
        return Optional.ofNullable(query.getSingleResult());
    }
}
