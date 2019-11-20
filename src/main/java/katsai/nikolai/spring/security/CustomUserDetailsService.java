package katsai.nikolai.spring.security;

import java.util.List;
import java.util.stream.Collectors;

import katsai.nikolai.spring.dao.UserDao;
import katsai.nikolai.spring.entity.Role;
import katsai.nikolai.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Can`t find user by username"));

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            builder.roles(getStringRolesArray(user.getRoles()));
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

    private String[] getStringRolesArray(List<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList()).toArray(String[]::new);
    }
}
