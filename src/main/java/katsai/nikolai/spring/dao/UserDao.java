package katsai.nikolai.spring.dao;

import java.util.List;
import java.util.Optional;

import katsai.nikolai.spring.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getById(Long userId);

    Optional<User> findByUsername(String username);
}
