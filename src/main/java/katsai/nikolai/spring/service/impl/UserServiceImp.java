package katsai.nikolai.spring.service.impl;

import java.util.List;

import katsai.nikolai.spring.dto.UserRegistrationDto;
import katsai.nikolai.spring.service.UserService;
import katsai.nikolai.spring.dao.UserDao;
import katsai.nikolai.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long userId) {
        return userDao.getById(userId);
    }

    @Override
    @Transactional
    public void registerNewUserAccount(UserRegistrationDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.addRole("USER");
        userDao.add(user);
    }

}
