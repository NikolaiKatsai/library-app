package katsai.nikolai.spring.service;

import java.util.List;

import katsai.nikolai.spring.dto.UserRegistrationDto;
import katsai.nikolai.spring.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getById(Long userId);

    void registerNewUserAccount(UserRegistrationDto userDto);
}
