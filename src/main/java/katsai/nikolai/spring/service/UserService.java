package katsai.nikolai.spring.service;

import java.util.List;
import java.util.Optional;

import katsai.nikolai.spring.dto.UserRegistrationDto;
import katsai.nikolai.spring.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long userId);

    Optional<User> findByUsername(String username);

    void registerNewUserAccount(UserRegistrationDto userDto);
}
