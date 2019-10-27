package mate.academy.spring.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import mate.academy.spring.dao.RentDao;
import mate.academy.spring.entity.Book;
import mate.academy.spring.entity.Rent;
import mate.academy.spring.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Rent add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
        return rent;
    }

    @Override
    public void returnBook(User user, Book book) {
        Query getRentQuery = sessionFactory.getCurrentSession()
                .createQuery("from Rent r where r.user_id = :user_id and r.book_id = :book_id");
        getRentQuery.setParameter("user_id", user.getId());
        getRentQuery.setParameter("book_id", book.getId());
        Rent rent = (Rent) getRentQuery.getSingleResult();
        rent.setActive(false);
        sessionFactory.getCurrentSession().update(rent);
    }

    @Override
    public List<Rent> getBooksRentByUser(User user) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("from Rent r where r.user_id = :userId"
                        + " and r.active = true", Rent.class);
        query.setParameter("userId", user.getId());
        return query.getResultList();
    }
}
